package com.example.kotlintest

import com.google.gson.annotations.SerializedName

// Data 담을 Value Object
class Datas(val text1: String,val text2: String)

data class User(
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("body")
    val body:String
)

// 배열 내부의 객체들 담을 object
data class Post(
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("body")
    val body:String
)