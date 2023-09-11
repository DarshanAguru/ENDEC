package com.example.endec

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class gen : AppCompatActivity() {

    private lateinit var sf:SharedPreferences
    private lateinit var sfe:SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gen)


        sf = getSharedPreferences("my_sp", MODE_PRIVATE)
        sfe = sf.edit()

        val gen = findViewById<Button>(R.id.btgenerate)
        val btnsave = findViewById<Button>(R.id.btnsave)

        var etkey = findViewById<TextView>(R.id.etKey3)

        gen.setOnClickListener {
            var key  = encdec.genKey()
            etkey.text = key
        }

        btnsave.setOnClickListener {
            var key = etkey.text.toString()
            if((key.isNullOrEmpty() or key.isBlank()) or (key.length != 32) )
            {
                Toast.makeText(applicationContext,"Please enter correct key or Generate new key",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext,"Key Saved", Toast.LENGTH_SHORT).show()
                sfe.apply {
                    putString("keyVal", key)
                    commit()
                }
            }
        }
    }
}