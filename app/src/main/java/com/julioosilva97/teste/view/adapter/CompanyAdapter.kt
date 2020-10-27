package com.julioosilva97.teste.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.julioosilva97.teste.R
import com.julioosilva97.teste.service.model.Company
import com.julioosilva97.teste.view.viewholder.CompanyViewHolder

class CompanyAdapter : RecyclerView.Adapter<CompanyViewHolder>() {

    private var mCompanyList : List<Company> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {

        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_company,parent,false)

        return CompanyViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mCompanyList.count()
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(mCompanyList[position])
    }

    fun updateGuests(list : List<Company>){
        mCompanyList = list
        notifyDataSetChanged()
    }

}