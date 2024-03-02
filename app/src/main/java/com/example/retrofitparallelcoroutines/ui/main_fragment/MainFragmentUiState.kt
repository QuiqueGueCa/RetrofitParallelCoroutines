package com.example.retrofitparallelcoroutines.ui.main_fragment

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel

sealed class MainFragmentUiState {

    data object Loading : MainFragmentUiState()
    data class Success(val payrollModel: PayrollModel) : MainFragmentUiState()
    data class Error(val msg: String) : MainFragmentUiState()
    data object StandBy : MainFragmentUiState()
}