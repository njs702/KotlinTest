package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BASE_URL:String = "https://jsonplaceholder.typicode.com"


        // Java
        /*RecyclerView mainRecyclerView = findViewById(R.id.activity_main_recyclerview)*/
        // Kotlin
        val mainRecyclerView: RecyclerView = findViewById(R.id.activity_main_recyclerview)

        /*val dataList = arrayListOf(
            Datas("1","2"),
            Datas("2","2"),
            Datas("3","2"),
            Datas("4","2")
        )*/


        //Retrofit builder
        val testRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Retrofit Api
        var testRetrofitApi: RetrofitService? = testRetrofit.create(RetrofitService::class.java)

        //Retrofit Api를 활용해 interface 구현
        //Response는 Post 형식의 데이터를 리스트로 받는다
        testRetrofitApi?.getPost()?.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                //응답 성공적일 때
                if(response.isSuccessful()){
                    var posts: List<Post>? = response.body()
                    Log.d("TEST","성공")
                    Log.d("TEST",posts?.size.toString())
                    mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                    mainRecyclerView.setHasFixedSize(true)
                    mainRecyclerView.adapter = posts?.let { DataAdapter(it as ArrayList<Post>) }
                }
                //응답 실패(400)
                else{
                    Log.d("TEST","실패(400)")
                }
            }
            //응답 실패(500), 시스템적 이유(인터넷 끊김)
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("TEST","실패(500)")
            }
        })

        // RecyclerView 연결


        /*testRetrofitApi?.getUser()?.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful()){
                    var user: User? = response.body()
                    Log.d("TEST","성공")
                    Log.d("TEST",user.toString())
                }
                else{
                    Log.d("TEST","실패(400)")
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("TEST","실패(500)")
            }
        })*/





    }


}