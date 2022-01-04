package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Java
        /*RecyclerView mainRecyclerView = findViewById(R.id.activity_main_recyclerview)*/
        // Kotlin
        val mainRecyclerView: RecyclerView = findViewById(R.id.activity_main_recyclerview)
        val dataList = arrayListOf(
            Datas("1","2"),
            Datas("2","2"),
            Datas("3","2"),
            Datas("4","2")
        )

        mainRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mainRecyclerView.setHasFixedSize(true)
        mainRecyclerView.adapter = DataAdapter(dataList)

    }
}