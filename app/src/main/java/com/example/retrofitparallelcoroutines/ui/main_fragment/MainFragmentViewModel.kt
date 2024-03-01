package com.example.retrofitparallelcoroutines.ui.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitparallelcoroutines.data.domain.model.error.ErrorModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.NameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetNamesListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val getNamesListUseCase: GetNamesListUseCase
) : ViewModel() {

    private val namesListErrorMutableSharedFlow = MutableSharedFlow<ErrorModel>()
    val namesListErrorSharedFlow: SharedFlow<ErrorModel> = namesListErrorMutableSharedFlow

    private val namesListMutableStateFlow =
        MutableStateFlow<MutableList<NameModel>>(mutableListOf())
    val namesListStateFlow: StateFlow<MutableList<NameModel>> = namesListMutableStateFlow

    private val names = mutableListOf<NameModel>()

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
}