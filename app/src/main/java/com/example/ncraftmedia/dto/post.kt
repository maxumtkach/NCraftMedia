package com.example.ncraftmedia.dto

open class Post(
    val author: String,
    val content: String,
    val created: String,  //data
    val likedByMe: Boolean = false
 //   val type: PostType = PostType.EVENTPOST
)