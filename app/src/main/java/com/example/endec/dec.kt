package com.example.endec

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class dec : AppCompatActivity() {

    private lateinit var sf: SharedPreferences
    private lateinit var sfe: SharedPreferences.Editor

    private lateinit var mtvInp: TextView
    private lateinit var mtvMsg: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dec)

        sf = getSharedPreferences("my_sp", MODE_PRIVATE)
        sfe = sf.edit()

        mtvInp = findViewById(R.id.etmInp2)
        mtvMsg = findViewById(R.id.etmMsg2)


        val btnEnc = findViewById<Button>(R.id.btDecrypt)



        btnEnc.setOnClickListener {

            var inptxt = mtvInp.text.toString()
            inptxt = inptxt.trim()
            var key = sf.getString("keyVal",null)
            if((inptxt.isBlank() or inptxt.isNullOrEmpty()) or (inptxt.length <= 10))
            {
                Toast.makeText(applicationContext,"Please Enter correct Encrypted text...", Toast.LENGTH_SHORT).show()
            }
            else if(key.isNullOrEmpty())
            {
                Toast.makeText(applicationContext,"Please save the Key...",Toast.LENGTH_SHORT).show()
            }
            else{
                var decrypt = encdec.decrypt(key,inptxt)


                if(decrypt.isNullOrEmpty())
                {
                    Toast.makeText(applicationContext,"Please save the correct Key or enter correct enc. text ...",Toast.LENGTH_SHORT).show()
                }
                else {
                    mtvMsg.text = decrypt
                }
            }
        }

    }
}