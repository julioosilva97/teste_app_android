package com.julioosilva97.teste.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.service.model.CompanyWithCountry
import com.julioosilva97.teste.service.repository.CompanyRepository

class MainViewModel(application: Application) : AndroidViewModel(application)  {

    private val mCompanyRepository = CompanyRepository(application.applicationContext)

    private val mCompanyList = MutableLiveData<List<Company>>()
    val  companyList: LiveData<List<Company>> = mCompanyList

    fun save(companyWithCountry:CompanyWithCountry){

        if(companyWithCountry.company.id?.let { findById(it) } ==null){
            mCompanyRepository.save(companyWithCountry)
        }
    }

    fun load(){
        mCompanyList.value = mCompanyRepository.getAll()
    }

    fun findById(id: Long): Company {
        return mCompanyRepository.findById(id)
    }
}