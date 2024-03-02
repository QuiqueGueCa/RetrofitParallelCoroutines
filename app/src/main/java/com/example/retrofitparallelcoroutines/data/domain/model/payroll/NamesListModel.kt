package com.example.retrofitparallelcoroutines.data.domain.model.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class NamesListModel(
    val names: MutableList<NameModel> = mutableListOf()
) : BaseModel()
