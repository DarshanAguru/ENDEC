package com.example.endec

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast



class enc : AppCompatActivity() {

    private lateinit var mtvInp:TextView
    private lateinit var mtvMsg: TextView


    private lateinit var sf: SharedPreferences
    private lateinit var sfe: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enc)

        mtvInp = findViewById(R.id.etmInp)
        mtvMsg = findViewById(R.id.etmMsg)


        sf = getSharedPreferences("my_sp", MODE_PRIVATE)
        sfe = sf.edit()


        val btnEnc = findViewById<Button>(R.id.btEncrypt)


        btnEnc.setOnClickListener {

            var inptxt = mtvInp.text.toString()
            inptxt = inptxt.trim()
            var key = sf.getString("keyVal",null)
            if(inptxt.isBlank() or inptxt.isNullOrEmpty())
            {
                Toast.makeText(applicationContext,"Please Enter Text",Toast.LENGTH_SHORT).show()
            }
            else if(key.isNullOrEmpty())
            {
                Toast.makeText(applicationContext,"Please save the correct Key...",Toast.LENGTH_SHORT).show()
            }
            else{
                var encrypt = encdec.encrypt(inptxt,key)
                if(encrypt.isNullOrEmpty())
                {
                    Toast.makeText(applicationContext,"Technical Error Please try again", Toast.LENGTH_SHORT).show()
                }
                else {
                    mtvMsg.text = encrypt

                }
            }
        }



    }
}