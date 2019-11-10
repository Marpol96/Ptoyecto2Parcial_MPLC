package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {

    val mRandom=Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button_Play.setOnClickListener{
            ChekcApuesta()
            jugarya()
        }
    }

    fun ChekcApuesta(){
        if(text_Apuesta.text.toString().isEmpty()){
            Toast.makeText(this,"No se Puede Empesar Sin Una Apuesta",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Suerte!",Toast.LENGTH_SHORT).show()
        }
    }
    fun moverimagenes(): Int {
        Vista1.setImageResource(R.drawable.mover)
        Vista2.setImageResource(R.drawable.mover)
        Vista3.setImageResource(R.drawable.mover)


        return mRandom.nextInt(3 -1)+1

    }

    fun jugarya(){
        var i=0
        val slot= arrayListOf("avion","camion","tren")
        while (i<=50000000) {
            val s1 = moverimagenes()
            val s2 = moverimagenes()
            val s3 = moverimagenes()

            if (s1==1){
                slotimagen1()
            }
            i=i+1
        }


    }

    fun slotimagen1(){
        Vista1.setImageResource(R.drawable.avion)
    }

    fun slotimagen2(){
        Vista2.setImageResource(R.drawable.camion)
    }

    fun slotimagen3(){
        Vista3.setImageResource((R.drawable.tren))
    }

    }

