package com.julioosilva97.teste.view

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.julioosilva97.teste.R
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.service.model.CompanyWithCountry
import com.julioosilva97.teste.service.model.Country
import com.julioosilva97.teste.view.adapter.CompanyAdapter
import com.julioosilva97.teste.viewmodel.MainViewModel
import org.json.JSONArray
import java.io.InputStream
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel : MainViewModel
    private val mAdapter: CompanyAdapter = CompanyAdapter()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        readJson()

        val recycler = findViewById<RecyclerView>(R.id.recycler_view)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

        observer()
        mViewModel.load()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }

    private fun observer() {
        mViewModel.companyList.observe(this, Observer {
            mAdapter.updateGuests(it)
        })
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun readJson(){

        val inputStream:InputStream = assets.open("empresas.json")
        val json = inputStream.bufferedReader().use { it.readText() }

        val jsonArray = JSONArray(json)
        val numberOfItemsInResp  = jsonArray.length();
        for(i in 0..numberOfItemsInResp-1){

            var jsonObj = jsonArray.getJSONObject(i)

            var company = Company().apply {
                this.id = jsonObj.getString("id").toLong()
                this.name = jsonObj.getString("empresa")
                this.dateRegister = LocalDateTime.parse(jsonObj.getString("data_cadastro"))
            }

            var jsonCountries = jsonObj.getJSONArray("paises_filiais")
            var countries = arrayListOf<Country>()

            for(j in 0..jsonCountries.length()-1){

                var country = Country().apply {
                    this.name = jsonCountries.get(j).toString()
                }

                countries.add(country)
            }

            var companyWithCountry: CompanyWithCountry =  CompanyWithCountry(company,countries)

            mViewModel.save(companyWithCountry)
        }

    }
}