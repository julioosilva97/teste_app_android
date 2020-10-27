package com.julioosilva97.teste.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "company")
data class Company (

    @PrimaryKey
    var id : Long? = null,

    var name : String = "",

    @ColumnInfo(name="date_register")
    var dateRegister : LocalDateTime? = null

)