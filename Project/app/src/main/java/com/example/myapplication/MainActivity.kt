package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R.id.button_Bonus
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {
    var estado:String="Perdio"
    val mRandom=Random()
    var g:Int= 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slotimagen1()
        slotimagen2()
        slotimagen3()
        button_Bonus.setOnClickListener{
            Bonus(estado)
        }
        Button_Play.setOnClickListener {
            ChekcApuesta()
        }
    }

    fun ChekcApuesta(){
        if(text_Credit.text =="0"){
            Toast.makeText(this,"No se Puede Empezar Sin Un Credito Disponible",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"El Juego Se Reiniciara!",Toast.LENGTH_SHORT).show()
            text_Credit.setText("100")
            g=100
        }else{
            Toast.makeText(this,"Suerte!",Toast.LENGTH_SHORT).show()
            jugarya()
        }
    }
    fun Bonus(e:String){
        button_Bonus.setOnClickListener{
            if (e == "Gano") {
                Toast.makeText(this, "Ganaste Ahora Puedes Ganar 20 Puntos!", Toast.LENGTH_LONG).show()

            } else if (e == "Perdio") {
                Toast.makeText(this, "Opcion Inhabilitada Por El Momento, Disponilble Solo Al Ganar!", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun Ganar(){
        estado="Gano"
        Bonus(estado)
        g=g+10
        text_Credit.text=g.toString()
    }
    fun Perder(){
        estado="Perdio"
        g=g-10
        text_Credit.text=g.toString()
    }
    fun moverimagenes(): Int {
        return mRandom.nextInt(9 -1)+1
    }
    fun jugarya(){
        val s1=moverimagenes()
        val s2=moverimagenes()
        val s3=moverimagenes()

        if(((s1==1)||(s1==2)||(s1==3))&&((s2==4)||s2==5||s2==6)&&((s3==7)||(s3==8)||(s3==9))){
            slotimagen1()
            slotimagen2()
            slotimagen3()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==1)&&(s3==2)){
            slot13()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==3)&&(s3==1)){
            slot12()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==1)&&(s3==1)){
            slotimagen1()
            slot21()
            slot31()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==2)&&(s3==2)){
            slot12()
            slotimagen2()
            slot32()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==3)&&(s3==3)){
            slot13()
            slot23()
            slotimagen3()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==1)&&(s3==2)){
            slotimagen1()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==1)&&(s3==3)){
            slotimagen1()
            slot21()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==2)&&(s3==1)){
            slotimagen1()
            slotimagen2()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==3)&&(s3==1)){
            slotimagen1()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==1)&&(s3==1)){
            slot12()
            slot21()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==1)&&(s3==1)){
            slot13()
            slot21()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==2)&&(s3==1)){
            slot12()
            slotimagen2()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==2)&&(s3==3)){
            slot12()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==1)&&(s3==2)){
            slot12()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==3)&&(s3==2)){
            slot12()
            slot23()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==2)&&(s3==2)){
            slotimagen1()
            slotimagen2()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==2)&&(s3==2)){
            slot13()
            slotimagen2()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==3)&&(s3==1)){
            slot13()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==3)&&(s3==2)){
            slot13()
            slot23()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==1)&&(s3==3)){
            slot13()
            slot21()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&(s2==2)&&(s3==3)){
            slot13()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&(s2==3)&&(s3==3)){
            slotimagen1()
            slot23()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&(s2==3)&&(s3==3)){
            slot12()
            slot23()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else{
            estado="Perdio"
            Bonus(estado)
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
