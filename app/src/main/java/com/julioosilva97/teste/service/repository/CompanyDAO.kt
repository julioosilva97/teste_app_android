package com.julioosilva97.teste.service.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.service.model.Country

@Dao
interface CompanyDAO {

    @Transaction
    @Insert
    fun save(company:Company) : Long

    @Query("select * from company")
    fun getAll(): List<Company>

    @Query("select * from company where id = :id")
    fun findById(id: Long): Company
}