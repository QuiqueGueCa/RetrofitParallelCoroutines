package com.example.retrofitparallelcoroutines.data.domain.model.user

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class NamesListModel(
    val users: MutableList<NameModel> = mutableListOf()
) : BaseModel()
