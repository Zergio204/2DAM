package com.example.deberes2709

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deberes2709.databinding.ActivityMainBinding

private val i = 11

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    var num1:Int = 0
    var num2:Int = 0
    var operador1: Boolean = true
    var simb:String = ""
    var num: Int = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


      /*  var listener: View.OnClickListener = View.OnClickListener { boton->
            num=(boton as Button).text.toString().toInt()
            asignarNumero(num)
            binding.resultado.text = num.toString()
        }

        binding.button.setOnClickListener(listener)
        binding.button2.setOnClickListener(listener)
        binding.button3.setOnClickListener(listener)
        binding.button4.setOnClickListener(listener)
        binding.button5.setOnClickListener(listener)
        binding.button6.setOnClickListener(listener)
        binding.button7.setOnClickListener(listener)
        binding.button8.setOnClickListener(listener)
        binding.button9.setOnClickListener(listener)*/
        binding.button10.setOnClickListener() {
            simb = "+"
            binding.resultado.text = simb
        }

        binding.button11.setOnClickListener {
            var result =0
            if (simb == "+") {
                 result=num1 + num2
            } else if (simb == "-") {
                result=num1 - num2
            }
            Log.d("depurando", "num1: $num1"+"+/- num2: $num2")
            binding.resultado.text = result.toString()
            num1 = 0
            num2 = 0

            simb = ""
        }

        binding.button12.setOnClickListener() {
            simb = "-"
            binding.resultado.text = simb
        }

        binding.button13.setOnClickListener() {
            simb = ""
            binding.resultado.text = simb
        }
    }

    private fun asignarNumero(num: Int) {
        if (operador1) {
            num1 = num
        } else {
            num2 = num
        }
        operador1=!operador1
    }

    override fun onClick(boton: View?) {
        num=(boton as Button).text.toString().toInt()
        asignarNumero(num)
        binding.resultado.text = num.toString()
    }
}