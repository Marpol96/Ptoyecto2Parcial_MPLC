package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {

    val mRandom=Random()
    var g:Int= 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button_Play.setOnClickListener {
            ChekcApuesta()
        }
    }

    fun ChekcApuesta(){
        if(text_Credit.text=="0"){
            Toast.makeText(this,"No se Puede Empesar Sin Un Credito Disponible",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"El Juego Se Reiniciara!",Toast.LENGTH_SHORT).show()
            g=100
        }else{
            Toast.makeText(this,"Suerte!",Toast.LENGTH_SHORT).show()
            jugarya()
        }
    }
    fun Ganar(){
        g=g+10
        text_Credit.text=g.toString()
    }
    fun Perder(){
        g=g-10
        text_Credit.text=g.toString()
    }
    fun moverimagenes(): Int {
        return mRandom.nextInt(3 -1)+1
    }
    fun jugarya(){
        val s1=moverimagenes()
        val s2=moverimagenes()
        val s3=moverimagenes()

        if((s1==1)&&(s2==2)&&(s3==3)){
            slotimagen1()
            slotimagen2()
            slotimagen3()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==1)&&(s3==2)){
            slot13()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==3)&&(s3==1)){
            slot12()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==1)&&(s3==1)){
            slotimagen1()
            slot21()
            slot31()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==2)&&(s3==2)){
            slot12()
            slotimagen2()
            slot32()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==3)&&(s3==3)){
            slot13()
            slot23()
            slotimagen3()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==1)&&(s3==2)){
            slotimagen1()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==1)&&(s3==3)){
            slotimagen1()
            slot21()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==2)&&(s3==1)){
            slotimagen1()
            slotimagen2()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==3)&&(s3==1)){
            slotimagen1()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==1)&&(s3==1)){
            slot12()
            slot21()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==1)&&(s3==1)){
            slot13()
            slot21()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==2)&&(s3==1)){
            slot12()
            slotimagen2()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==2)&&(s3==3)){
            slot12()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==1)&&(s3==2)){
            slot12()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==3)&&(s3==2)){
            slot12()
            slot23()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==2)&&(s3==2)){
            slotimagen1()
            slotimagen2()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==2)&&(s3==2)){
            slot13()
            slotimagen2()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==3)&&(s3==1)){
            slot13()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==3)&&(s3==2)){
            slot13()
            slot23()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==1)&&(s3==3)){
            slot13()
            slot21()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==3)&&(s2==2)&&(s3==3)){
            slot13()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==1)&&(s2==3)&&(s3==3)){
            slotimagen1()
            slot23()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if((s1==2)&&(s2==3)&&(s3==3)){
            slot12()
            slot23()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"No Existe Combinacion!",Toast.LENGTH_SHORT).show()
        }
    }
    fun slot12(){
        Vista1.setImageResource(R.drawable.camion)
    }
    fun slot13(){
        Vista1.setImageResource(R.drawable.tren)
    }
    fun slot21(){
        Vista2.setImageResource(R.drawable.avion)
    }
    fun slot23(){
        Vista2.setImageResource(R.drawable.tren)
    }
    fun slot31(){
        Vista3.setImageResource(R.drawable.avion)
    }
    fun slot32(){
        Vista3.setImageResource(R.drawable.camion)
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
