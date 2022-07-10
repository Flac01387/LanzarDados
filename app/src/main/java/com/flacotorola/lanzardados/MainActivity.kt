package com.flacotorola.lanzardados

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_lanzar: Button = findViewById(R.id.btn_lanzar)

        btn_lanzar.setOnClickListener{
            tiempo()
        }

        rollDice()
    }

    private fun rollDice(){
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.txt_resultado)
        txtResult.text = numero.toString()
        //Toast.makeText(this,"Se lanzó el dado", Toast.LENGTH_SHORT).show()

        val imgDado: ImageView = findViewById(R.id.img_Dado)

        when(numero) {
            1 -> imgDado.setImageResource(R.drawable.dice_1)
            2 -> imgDado.setImageResource(R.drawable.dice_2)
            3 -> imgDado.setImageResource(R.drawable.dice_3)
            4 -> imgDado.setImageResource(R.drawable.dice_4)
            5 -> imgDado.setImageResource(R.drawable.dice_5)
            else -> imgDado.setImageResource(R.drawable.dice_6)
        }
    }

    private fun lanzar(max: Int): Int{
        return (1..max).random()
    }

    private fun tiempo(){

        val btn_lanzar: Button = findViewById(R.id.btn_lanzar)
        btn_lanzar.setEnabled(false)

        val mp3Agitar = MediaPlayer.create(this, R.raw.sacudir)
        mp3Agitar.start()

        object: CountDownTimer(3000,100){
            override fun onTick(p0: Long) {
                rollDice()
            }

            override fun onFinish() {
                btn_lanzar.setEnabled(true)
            }
        }.start()
    }
}