package com.example.ejercicio18

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio18.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferencesLectura = getSharedPreferences("preferencias", MODE_PRIVATE)
        val nombre = sharedPreferencesLectura.getString("nombre", "Sin Definir")
        val telefono = sharedPreferencesLectura.getString("telefono", "Sin Definir")
        binding.usuario = Usuario(nombre!!, telefono!!)


    }
}