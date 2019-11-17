package com.example.myapplication
/* Autor: Martin Paul Leiva Cruz
    Clase: Programacion Orientada a Obejtos
    Catedratico: Ing. Hector Sabillon
 */
import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.EndElementListener
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var estado:String=""
    val mRandom=Random()
    var g:Int= 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slotimagen1()
        slotimagen2()
        slotimagen3()
        Button_Play.setOnClickListener {
            ChekcApuesta()
        }
    }

    /* comentarios de la app
    Breve Explicacion
    En este juego se gana de 4 maneras
    1> sacando las tres imagenes de aviones
    2> sacando las tres imagenes de Camiones
    3> sacando las tres Imagenes de trenes
    4> sacando en orden las imagenes >> Avion,Camion,Tren


    El Bonus No se podra utilizar si no se ha ganado para ello se declaro una variable
    estado donde variara y de esta dependera el bono

    El Bono Consite en Adivinar un Numero Escondido en un textview
    en intervalos del 1-9

    el numero se mostrara luego de teclear bono y registrar numero pensado
    se manejara un credito de 1000 con una apuesta estable de 10 esta variara en su defecto
    si gana o pierde, si gana el bono son 20 los que gana y si lo pierde solo son 10 lo
    que pierde.
     */
    fun ChekcApuesta(){
        if(text_Credit.text =="0"){
            Toast.makeText(this,"No se Puede Empezar Sin Un Credito Disponible",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"El Juego Se Reiniciara!",Toast.LENGTH_SHORT).show()
            text_Credit.setText("1000")
            g=1000
        }else{
            Toast.makeText(this,"Suerte!",Toast.LENGTH_SHORT).show()
            jugarya()
        }
    }
    fun Bonus(e:String){
        button_Bonus.setOnClickListener{
            if (e == "Gano") {
                var NO:Int=moverimagenes()
                if(text_pedir.text.toString()==NO.toString()){
                    var g1:Int=text_Credit.text.toString().toInt()
                    g1=g1+20
                    text_Credit.text=g1.toString()
                    Toast.makeText(this, "Ganaste 20 Puntos!", Toast.LENGTH_LONG).show()
                    text_NumOculto.text=NO.toString()
                    Thread.sleep(5*1000)
                    estado="Perdio"
                }else{
                    Perder()
                    estado="Perdio"
                    Thread.sleep(5*1000)
                    text_NumOculto.text=NO.toString()
                }
            }
            Toast.makeText(this, "A Continuar Jugando!", Toast.LENGTH_LONG).show()
            slot12()
            slotimagen2()
            slotimagen3()
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
        Bonus(estado)
        g=g-10
        text_Credit.text=g.toString()
    }
    fun moverimagenes(): Int {
        return mRandom.nextInt(9 -1)+1
    }
    fun jugarya(){
        text_NumOculto.setText("X")
        val s1=moverimagenes()
        val s2=moverimagenes()
        val s3=moverimagenes()

        if(((s1==1)||(s1==2)||(s1==3))&&((s2==4)||s2==5||s2==6)&&((s3==7)||(s3==8)||(s3==9))){
            slotimagen1()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==1)||(s2==2)||(s2==3))&&((s3==4)||(s3==5)||(s3==6))){
            slot13()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==7)||(s2==8)||(s2==9))&&((s3==1)||(s3==2)||(s3==3))){
            slot12()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==1)||(s2==2)||(s2==3))&&((s3==1)||(s3==2)||(s3==3))){
            slotimagen1()
            slot21()
            slot31()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==4)||(s2==5)||(s2==6))&&((s3==4)||(s3==5)||(s3==6))){
            slot12()
            slotimagen2()
            slot32()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==7)||(s2==8)||(s2==9))&&((s3==7)||(s3==8)||(s3==9))){
            slot13()
            slot23()
            slotimagen3()
            Ganar()
            Toast.makeText(this,"Felicidades, Ganaste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==1)||(s2==2)||(s2==3))&&((s3==4)||(s3==5)||(s3==6))){
            slotimagen1()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==1)||(s2==2)||(s2==3))&&((s3==7)||(s3==8)||(s3==9))){
            slotimagen1()
            slot21()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==4)||(s2==5)||(s2==6))&&((s3==1)||(s3==2)||(s3==3))){
            slotimagen1()
            slotimagen2()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==7)||(s2==8)||(s2==9))&&((s3==1)||(s3==2)||(s3==3))){
            slotimagen1()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==1)||(s2==2)||(s2==3))&&((s3==1)||(s3==2)||(s3==3))){
            slot12()
            slot21()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==1)||(s2==2)||(s2==3))&&((s3==1)||(s3==2)||(s3==3))){
            slot13()
            slot21()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==4)||(s2==5)||(s2==6))&&((s3==1)||(s3==2)||(s3==3))){
            slot12()
            slotimagen2()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==4)||(s2==5)||(s2==6))&&((s3==7)||(s3==8)||(s3==9))){
            slot12()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==1)||(s2==2)||(s2==3))&&((s3==4)||(s3==5)||(s3==6))){
            slot12()
            slot21()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==7)||(s2==8)||(s2==9))&&((s3==4)||(s3==5)||(s3==6))){
            slot12()
            slot23()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==4)||(s2==5)||(s2==6))&&((s3==4)||(s3==5)||(s3==6))){
            slotimagen1()
            slotimagen2()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==4)||(s2==5)||(s2==6))&&((s3==4)||(s3==5)||(s3==6))){
            slot13()
            slotimagen2()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==7)||(s2==8)||(s2==9))&&((s3==1)||(s3==2)||(s3==3))){
            slot13()
            slot23()
            slot31()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==7)||(s2==8)||(s2==9))&&((s3==4)||(s3==5)||(s3==6))){
            slot13()
            slot23()
            slot32()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==1)||(s2==2)||(s2==3))&&((s3==7)||(s3==8)||(s3==9))){
            slot13()
            slot21()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==7)||(s1==8)||(s1==9))&&((s2==4)||(s2==5)||(s2==6))&&((s3==7)||(s3==8)||(s3==9))){
            slot13()
            slotimagen2()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==1)||(s1==2)||(s1==3))&&((s2==7)||(s2==8)||(s2==9))&&((s3==7)||(s3==8)||(s3==9))){
            slotimagen1()
            slot23()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else if(((s1==4)||(s1==5)||(s1==6))&&((s2==7)||(s2==8)||(s2==9))&&((s3==7)||(s3==8)||(s3==9))){
            slot12()
            slot23()
            slotimagen3()
            Perder()
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
        }else{
            estado="Perdio"
            Bonus(estado)
            Toast.makeText(this,"Perdiste!",Toast.LENGTH_SHORT).show()
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

