package com.julioosilva97.teste.service.model

import androidx.room.Embedded
import androidx.room.Relation

data class CompanyWithCountry (

    @Embedded
    var company: Company,

    @Relation(
        parentColumn = "id",
        entityColumn = "companyId"
    )
    var countries: List<Country>
)