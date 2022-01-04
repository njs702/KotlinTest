package com.example.kotlintest

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val dataList: ArrayList<Datas>): RecyclerView.Adapter<DataAdapter.DataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DataAdapter.DataViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}