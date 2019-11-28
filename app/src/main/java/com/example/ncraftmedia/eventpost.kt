package com.example.ncraftmedia

import com.example.ncraftmedia.dto.Post

class EventPost(
    author: String,
    content: String,
    created: String,  //data
    likedByMe: Boolean = false,

    val address: String,
    val coordFirst: Double,
    val coordSecond: Double

) : Post(author, content, created, likedByMe)