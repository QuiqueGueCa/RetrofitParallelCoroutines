package com.example.retrofitparallelcoroutines.ui.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import com.example.retrofitparallelcoroutines.data.domain.model.UserModel
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
import com.example.retrofitparallelcoroutines.data.domain.use_cases.PostPayrollUseCase
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
    private val getSalaryUseCase: GetSalaryUseCase,
    private val postPayrollUseCase: PostPayrollUseCase
) : ViewModel() {

    private val _namesListError = MutableSharedFlow<ErrorModel>()
    val namesListError: SharedFlow<ErrorModel> = _namesListError

    private val _surnameError = MutableSharedFlow<ErrorModel>()
    val surnameError: SharedFlow<ErrorModel> = _surnameError

    private val _jobError = MutableSharedFlow<ErrorModel>()
    val jobError: SharedFlow<ErrorModel> = _jobError

    private val _salaryError = MutableSharedFlow<ErrorModel>()
    val salaryError: SharedFlow<ErrorModel> = _salaryError

    private val _payrollError = MutableSharedFlow<ErrorModel>()
    val payrollError: SharedFlow<ErrorModel> = _payrollError


    private val _namesList =
        MutableStateFlow<MutableList<NameModel>>(mutableListOf())
    val namesList: StateFlow<MutableList<NameModel>> = _namesList

    private val _uiState = MutableStateFlow<MainFragmentUiState>(MainFragmentUiState.LoadingList)
    val uiState: StateFlow<MainFragmentUiState> = _uiState

    private val names = mutableListOf<NameModel>()
    private var surnameModel = SurnameModel()
    private var jobModel = JobModel()
    private var salaryModel = SalaryModel()

    fun getNamesList() {
        viewModelScope.launch(Dispatchers.IO) {
            getNamesListUseCase().collect {
                when (it) {
                    is BaseResponse.Error -> {
                        _namesListError.emit(it.error)
                    }

                    is BaseResponse.Success -> {
                        names.addAll(it.data.names)
                        _namesList.value = names
                        _uiState.value = MainFragmentUiState.ListLoaded
                    }
                }
            }
        }
    }

    fun getPayroll(idUser: Int) {
        _uiState.value = MainFragmentUiState.LoadingUserData

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

            postPayroll(idUser)
        }
    }

    private fun postPayroll(idUser: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            postPayrollUseCase(
                PayrollModel(
                    idUser,
                    surnameModel.name,
                    surnameModel.surname,
                    jobModel.company,
                    salaryModel.salary,
                )
            ).collect {
                when (it) {
                    is BaseResponse.Error -> {
                        _payrollError.emit(it.error)
                    }

                    is BaseResponse.Success -> {
                        _uiState.value = MainFragmentUiState.Success(
                            UserModel(
                                idUser,
                                surnameModel.name,
                                surnameModel.surname,
                                jobModel.company,
                                jobModel.job,
                                salaryModel.salary,
                                salaryModel.tax,
                                salaryModel.formation,
                                it.data.total
                            )
                        )
                    }
                }
            }
        }
    }

    private suspend fun getSalary(flow: Flow<BaseResponse<out BaseModel>>) {
        flow.collect {
            when (it) {
                is BaseResponse.Error -> {
                    _salaryError.emit(it.error)
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
                    _jobError.emit(it.error)
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
                    _surnameError.emit(it.error)
                }

                is BaseResponse.Success -> {
                    surnameModel = it.data as SurnameModel
                }
            }
        }
    }
}