package com.julioosilva97.teste.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class Country (

    @PrimaryKey(autoGenerate = true)
    var id : Long? = null,

    var name : String = "",

    var companyId : Long? = null
)