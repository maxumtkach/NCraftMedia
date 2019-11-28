package com.example.ncraftmedia

class EventPost(
    author: String,
    content: String,
    created: String,  //data
    likedByMe: Boolean = false,

    val address: String,
    val coordFirst: Double,
    val coordSecond: Double

) : Post(author, content, created, likedByMe)