package com.example.kotlintest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    // post 정보 GET
    @GET("/posts")
    /*fun getPost(@Query("userId")userId:Int,
                @Query("id")id:Int,
                @Query("title")title:String,
                @Query("body")body:String) : Call<List<Post>> // list 자료형으로 JSON 데이터 받기*/
    fun getPost() : Call<List<Post>>

    @GET("/posts/1")
    fun getUser(): Call<User>
}