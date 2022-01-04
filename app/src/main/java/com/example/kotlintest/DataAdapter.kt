package com.example.kotlintest

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val dataList: ArrayList<Datas>): RecyclerView.Adapter<DataAdapter.DataViewHolder>(){

    // 보여줄 데이터의 개수 만큼 View 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ex_list,parent,false)
        return DataViewHolder(view)
    }

    // 생성된 View에 보여줄 데이터 set
    override fun onBindViewHolder(holder: DataAdapter.DataViewHolder, position: Int) {
        holder.tv1.text = dataList.get(position).text1
        holder.tv2.text = dataList.get(position).text2
    }

    // 생성된 View의 개수 return
    override fun getItemCount(): Int {
        return dataList.size
    }

    // ViewHolder 단위 객체로 View의 데이터 설정
    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tv1 = itemView.findViewById<TextView>(R.id.ex_list_tv1)
        val tv2 = itemView.findViewById<TextView>(R.id.ex_list_tv2)
    }

}