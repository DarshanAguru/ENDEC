package com.example.endec

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val btnenc = findViewById<Button>(R.id.btEnc)
        val btndec = findViewById<Button>(R.id.btDec)
        val btngen = findViewById<Button>(R.id.btgen)

        btnenc.setOnClickListener {
            var intent = Intent(applicationContext, enc::class.java)
            startActivity(intent)
        }

        btndec.setOnClickListener {
            var intent = Intent(applicationContext, dec::class.java)
            startActivity(intent)
        }

        btngen.setOnClickListener {
            var intent = Intent(applicationContext, gen::class.java)
            startActivity(intent)
        }


    }
}