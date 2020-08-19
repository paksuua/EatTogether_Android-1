package com.example.eattogether_neep.UI.Activity


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.example.eattogether_neep.R
import com.example.eattogether_neep.SOCKET.SocketService
import com.example.eattogether_neep.UI.User
import kotlinx.android.synthetic.main.activity_ranking.*
import kotlinx.android.synthetic.main.activity_waiting.*

class WaitingActivity : AppCompatActivity() {
    private var like = ""
    private var hate = ""
    private var roomName = ""
    private var fullNumber = -1
    private var enterNumber = 0
    private lateinit var socketReceiver: WaitingReceiver
    private lateinit var intentFilter: IntentFilter
    private lateinit var uuid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiting)

        // loading git
        Glide.with(this).load(R.drawable.loading).into(img_rotate)

        like = intent.getStringExtra("like")
        hate = intent.getStringExtra("hate")
        roomName = intent.getStringExtra("roomName")
        uuid = User.getUUID(this)

        fullNumber = intent.getIntExtra("fullNum", -1)
        fullNum.setText(" / " + fullNumber.toString())
        socketReceiver = WaitingReceiver()
        intentFilter = IntentFilter()
        with(intentFilter){
            addAction("com.example.eattogether_neep.FOOD_LIST")
            addAction("com.example.eattogether_neep.ENTER_COUNT")
        }

        registerReceiver(socketReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        sendPreference(like, hate, uuid, roomName)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(socketReceiver)
    }
}


