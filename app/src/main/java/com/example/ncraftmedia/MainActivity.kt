package com.example.ncraftmedia

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Timestamp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.*


class MainActivity : AppCompatActivity() {
    private var lat = ""
    private var lon = ""
    private var countLike: Int = 0     // счетчики
    private var countChat: Int = 0
    private var countShare: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeValue = System.currentTimeMillis()//----------------

        val stamp = Timestamp(timeValue)
        val date = Date(stamp.getTime())

        val post = Post(
            "Netology", "First post in our network!", "$date",
            false
        )
        val post1 = EventPost(
            "Netology", "First post in our network!", "$date",
            false, "address", 0.00, 0.00
        )

        btn_image_like.setOnClickListener {

            if (countLike != 0) {

                countLike--
                like_text.text = countLike.toString()

                btn_image_like.setImageResource(R.drawable.ic_favorite_inactive_24dp)
                toColorDisactiv()

            } else {

                btn_image_like.setImageResource(R.drawable.ic_favorite_red_24dp)
                countLike++
                like_text.text = countLike.toString()
                toColorActiv()
            }
        }
        latitude_text.text = post1.coordFirst.toString()
        longitude_text.text = post1.coordSecond.toString()
        address_text.text = post1.address
        toInfo(post)
    }

    fun toInfo(post: Post) {

        data_text.text = post.created
        post_text.text = post.content
        netology_text.text = post.author
    }


    fun locationByMe(view: View) {
        val intent = Intent().apply {
            //       val lat = ""
            //     val lon = ""
            data = Uri.parse("geo:$lat,$lon")
            action = Intent.ACTION_VIEW
            putExtra(
                Intent.EXTRA_TEXT, """
                (${latitude_text.text})${longitude_text.text}
            """.trimIndent()
            )
            type = "text/plain"
        }
        startActivity(intent)
    }

    private fun toColorDisactiv() {
        if (countLike == 0) {
            like_text.setTextColor(Color.rgb(255, 255, 255))
        }
    }

    private fun toColorActiv() {
        if (countLike != 0 || countChat != 0 || countShare != 0) {
            like_text.setTextColor(Color.rgb(255, 0, 0))
        }
    }

    fun chatClick(view: View) {

        btn_image_chat.setImageResource(R.drawable.ic_chat_bubble_24dp)
        countChat++
        chat_text.text = countChat.toString()
        toColorActiv()
        toColorDisactiv()
    }

    fun shareClick(view: View) {

        share_btn.setImageResource(R.drawable.ic_share_24dp)
        countShare++
        share_text.text = countShare.toString()
        toColorActiv()
        toColorDisactiv()
    }


}