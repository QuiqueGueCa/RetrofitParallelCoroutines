package com.example.retrofitparallelcoroutines.ui.main_fragment

import com.example.retrofitparallelcoroutines.data.domain.model.UserModel

sealed class MainFragmentUiState {

    data object LoadingUserData : MainFragmentUiState()
    data object LoadingList : MainFragmentUiState()
    data class Success(val userModel: UserModel) : MainFragmentUiState()
    data class Error(val msg: String) : MainFragmentUiState()
    data object ListLoaded : MainFragmentUiState()
}