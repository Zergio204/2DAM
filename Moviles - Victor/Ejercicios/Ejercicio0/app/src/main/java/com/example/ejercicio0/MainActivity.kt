package com.example.ejercicio0

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio0.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

         */

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var texto:String=""

        binding.b1.setOnClickListener(){
            texto=texto + "1"
            binding.tvMostrar.text=texto

        }
        binding.b2.setOnClickListener(){
            texto=texto + "2"
            binding.tvMostrar.text=texto
        }
        binding.b3.setOnClickListener(){
            texto=texto + "3"
            binding.tvMostrar.text=texto
        }
        binding.b4.setOnClickListener(){
            texto=texto + "4"
            binding.tvMostrar.text=texto
        }
        binding.bBorrar.setOnClickListener(){
            texto=texto.dropLast(1)
            binding.tvMostrar.text=texto
        }
        binding.bEliminar.setOnClickListener(){
            texto=""
            binding.tvMostrar.text=texto
        }


    }
}