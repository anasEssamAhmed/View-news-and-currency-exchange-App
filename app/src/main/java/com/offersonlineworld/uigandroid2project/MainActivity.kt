package com.offersonlineworld.uigandroid2project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val anim = AnimationUtils.loadAnimation(this, R.anim.anam)
        textView.animation = anim
        Handler().postDelayed(
            {
                val i = Intent(this, Login::class.java)
                startActivity(i)
                finish()
            }, 5000)
    }
}