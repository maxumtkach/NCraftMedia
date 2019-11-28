package com.example.ncraftmedia

open class Post(
    val author: String,
    val content: String,
    val created: String,  //data
    val likedByMe: Boolean = false
)