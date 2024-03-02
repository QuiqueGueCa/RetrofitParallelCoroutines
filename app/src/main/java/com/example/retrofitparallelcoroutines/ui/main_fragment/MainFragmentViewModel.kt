package com.example.retrofitparallelcoroutines.ui.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import com.example.retrofitparallelcoroutines.data.domain.model.error.ErrorModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.JobModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.NameModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetJobUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetNamesListUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetSalaryUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetSurnameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val getNamesListUseCase: GetNamesListUseCase,
    private val getSurnameUseCase: GetSurnameUseCase,
    private val getJobUseCase: GetJobUseCase,
    private val getSalaryUseCase: GetSalaryUseCase
) : ViewModel() {

    private val namesListErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val namesListErrorSharedFlow: SharedFlow<ErrorModel> = namesListErrorMutableSharedFlow

    private val surnameErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val surnameErrorSharedFlow: SharedFlow<ErrorModel> = surnameErrorMutableSharedFlow

    private val jobErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val jobErrorSharedFlow: SharedFlow<ErrorModel> = jobErrorMutableSharedFlow

    private val salaryErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val salaryErrorSharedFlow: SharedFlow<ErrorModel> = salaryErrorMutableSharedFlow


    private val namesListMutableStateFlow =
        MutableStateFlow<MutableList<NameModel>>(mutableListOf())
    val namesListStateFlow: StateFlow<MutableList<NameModel>> = namesListMutableStateFlow

    private val payrollMutableStateFlow = MutableStateFlow(PayrollModel())
    val payrollStateFlow: StateFlow<PayrollModel> = payrollMutableStateFlow

    private val names = mutableListOf<NameModel>()
    private var surnameModel = SurnameModel()
    private var jobModel = JobModel()
    private var salaryModel = SalaryModel()
    //private var payrollModel = PayrollModel()

    fun getNamesList() {
        viewModelScope.launch(Dispatchers.IO) {
            getNamesListUseCase().collect {
                when (it) {
                    is BaseResponse.Error -> {
                        namesListErrorMutableSharedFlow.emit(it.error)
                    }

                    is BaseResponse.Success -> {
                        names.addAll(it.data.names)
                        namesListMutableStateFlow.value = names
                    }
                }
            }
        }
    }

    fun getPayroll(idUser: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val deferreds = listOf(
                async { getSurnameUseCase.invoke(idUser) },
                async { getJobUseCase.invoke(idUser) },
                async { getSalaryUseCase.invoke(idUser) }
            )
            val response = deferreds.awaitAll()
            getSurname(response[0])
            getJob(response[1])
            getSalary(response[2])

            payrollMutableStateFlow.value = PayrollModel(
                idUser,
                surnameModel.name,
                surnameModel.surname,
                jobModel.company,
                salaryModel.salary
            )
        }
    }

    private suspend fun getSalary(flow: Flow<BaseResponse<out BaseModel>>) {
        flow.collect {
            when (it) {
                is BaseResponse.Error -> {
                    salaryErrorMutableSharedFlow.emit(it.error)
                }

                is BaseResponse.Success -> {
                    salaryModel = it.data as SalaryModel
                }
            }
        }
    }

    private suspend fun getJob(flow: Flow<BaseResponse<out BaseModel>>) {
        flow.collect {
            when (it) {
                is BaseResponse.Error -> {
                    jobErrorMutableSharedFlow.emit(it.error)
                }

                is BaseResponse.Success -> {
                    jobModel = it.data as JobModel
                }
            }
        }
    }

    private suspend fun getSurname(flow: Flow<BaseResponse<out BaseModel>>) {
        flow.collect {
            when (it) {
                is BaseResponse.Error -> {
                    surnameErrorMutableSharedFlow.emit(it.error)
                }

                is BaseResponse.Success -> {
                    surnameModel = it.data as SurnameModel
                }
            }
        }
    }
}