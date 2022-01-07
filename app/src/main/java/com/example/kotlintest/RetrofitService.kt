package com.example.kotlintest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    // post 정보 GET
    @GET("/posts")
    fun getPost() : Call<List<Post>>

    @GET("/posts/1")
    fun getUser(): Call<User>
}