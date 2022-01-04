package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Java
        /*RecyclerView mainRecyclerView = findViewById(R.id.activity_main_recyclerview)*/
        // Kotlin
        val mainRecyclerView: RecyclerView = findViewById(R.id.activity_main_recyclerview)

    }
}