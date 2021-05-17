package com.thesparkfoundation.login

import android.content.Intent
import android.graphics.Color.alpha
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val iv_note=findViewById<ImageView>(R.id.iv_note)
       iv_note.alpha =0f
        iv_note.animate().setDuration(3000).alpha(1f).withEndAction{
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}