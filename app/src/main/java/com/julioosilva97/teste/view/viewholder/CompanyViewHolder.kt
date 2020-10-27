package com.julioosilva97.teste.view.viewholder


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.julioosilva97.teste.R
import com.julioosilva97.teste.service.model.Company

class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(company: Company) {
        val textName = itemView.findViewById<TextView>(R.id.name_company)
        textName.text = company.name
    }
}