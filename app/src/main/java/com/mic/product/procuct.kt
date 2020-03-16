package com.mic.product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_procuct.*

class procuct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procuct)
        btn_save.setOnClickListener {
            val replyintent=Intent(this,MainActivity::class.java)
            replyintent.putExtra("key","product")
            replyintent.putExtra("name","Maung Maung")
            replyintent.putExtra("price","3.44")
            replyintent.putExtra("quantity","")
            startActivity(replyintent)
            finish()
        }
    }
}
