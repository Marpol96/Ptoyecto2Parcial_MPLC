package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button_Play.setOnClickListener{ChekcApuesta()}
    }

    fun ChekcApuesta(){
        if(text_Apuesta.text.toString().isEmpty()){
            Toast.makeText(this,"No se Puede Empesar Sin Una Apuesta",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Suerte!",Toast.LENGTH_SHORT).show()
        }
    }
}

