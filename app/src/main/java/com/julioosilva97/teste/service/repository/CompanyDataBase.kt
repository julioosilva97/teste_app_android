package com.julioosilva97.teste.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.service.model.Country
import com.julioosilva97.teste.service.util.Converters

@Database(entities = [Company::class,Country::class],version = 1)
@TypeConverters(Converters::class)
abstract class CompanyDataBase : RoomDatabase() {

    abstract fun companyDAO() : CompanyDAO
    abstract fun countryDAO() : CountryDAO

    companion object {
        private lateinit var INSTANCE: CompanyDataBase

        fun getDataBase(context: Context): CompanyDataBase {
            if(!::INSTANCE.isInitialized){
                synchronized(CompanyDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, CompanyDataBase::class.java, "companyDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}