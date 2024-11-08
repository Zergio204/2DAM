package com.example.eje01_calculadora

import android.app.Activity
import android.os.Bundle
import android.view.View.OnClickListener
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eje01_calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mostrar:String="";

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bEliminar.setOnClickListener(){
            mostrar=""
            binding.tvResultado.text = mostrar
        }

        binding.bBorrar.setOnClickListener(){
            mostrar = mostrar.dropLast(1)
            binding.tvResultado.text = mostrar
        }

        fun comprobarSimbolo():Boolean{
            var esSimbolo:Boolean=true
            if (binding.tvResultado.text.last()!='-' && binding.tvResultado.text.last()!='+'){
                esSimbolo=false
            }

            return esSimbolo
        }

        binding.bResta.setOnClickListener(){

            if (comprobarSimbolo()==false){
                mostrar = mostrar + "-"
                binding.tvResultado.text = mostrar
            }

        }

        binding.bSuma.setOnClickListener(){

            if (comprobarSimbolo()==false){
                mostrar = mostrar + "+"
                binding.tvResultado.text = mostrar
            }

        }

        binding.b1.setOnClickListener(){
            mostrar = mostrar + "1"
            binding.tvResultado.text = mostrar
        }

        binding.b2.setOnClickListener(){
            mostrar = mostrar + "2"
            binding.tvResultado.text = mostrar
        }

        binding.b3.setOnClickListener(){
            mostrar = mostrar + "3"
            binding.tvResultado.text = mostrar
        }

        binding.b4.setOnClickListener(){
            mostrar = mostrar + "4"
            binding.tvResultado.text = mostrar
        }

        binding.b5.setOnClickListener(){
            mostrar = mostrar + "5"
            binding.tvResultado.text = mostrar
        }

        binding.b6.setOnClickListener(){
            mostrar = mostrar + "6"
            binding.tvResultado.text = mostrar
        }

        binding.b7.setOnClickListener(){
            mostrar = mostrar + "7"
            binding.tvResultado.text = mostrar
        }

        binding.b8.setOnClickListener(){
            mostrar = mostrar + "8"
            binding.tvResultado.text = mostrar
        }

        binding.b9.setOnClickListener(){
            mostrar = mostrar + "9"
            binding.tvResultado.text = mostrar
        }

        binding.b0.setOnClickListener(){
            mostrar = mostrar + "0"
            binding.tvResultado.text = mostrar
        }

        fun calcular():Int{
            var resultado:Int=0

            var num1:Int = mostrar[0].toInt()-48
            var num2:Int = mostrar[2].toInt()-48
            var simbolo:Char = mostrar[1]

            when(simbolo){
                '+' -> resultado=num1+num2
                '-' -> resultado=num1-num2
            }


            return resultado
        }

        binding.bIgual.setOnClickListener(){
            binding.tvResultado.text = calcular().toString()
            mostrar=""
        }

    }
}