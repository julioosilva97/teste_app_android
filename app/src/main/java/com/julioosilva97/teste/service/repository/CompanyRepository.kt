package com.julioosilva97.teste.service.repository

import android.content.Context
import android.os.AsyncTask
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.service.model.CompanyWithCountry
import com.julioosilva97.teste.service.model.Country

class CompanyRepository (context: Context) {

    private val mDataBase = CompanyDataBase.getDataBase(context).companyDAO()
    private val mDataBaseCountry = CompanyDataBase.getDataBase(context).countryDAO()

    fun save(companyWithCountry: CompanyWithCountry):Boolean{

        val companyId = mDataBase.save(companyWithCountry.company)

        var countries = arrayListOf<Country>()

        for(country in companyWithCountry.countries){
            country.companyId = companyId
            countries.add(country)
            mDataBaseCountry.save(country)
        }

        return  true
    }

    fun getAll(): List<Company> {

        return mDataBase.getAll()
    }

    fun findById(id: Long): Company {

        return mDataBase.findById(id)
    }


}