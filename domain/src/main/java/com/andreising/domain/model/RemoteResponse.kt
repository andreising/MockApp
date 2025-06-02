package com.andreising.domain.model

data class RemoteResponse(
    val optionList: List<OptionMainModel>,
    val vacancyList: List<VacancyMainModel>
)