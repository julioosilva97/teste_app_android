package com.julioosilva97.teste.service.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.service.model.Country

@Dao
interface CountryDAO {

    @Transaction
    @Insert
    fun save(country: Country) : Long

}