package com.example.ejem15_sharedpreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejem15_sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferenceLectura = getSharedPreferences("preferencias", MODE_PRIVATE)
        val nombre = sharedPreferenceLectura.getString("nombre", "no definido")
        val contrasena = sharedPreferenceLectura.getString("contrasena", "no definido")
        binding.usuario = Usuario(nombre!!, contrasena!!)


        binding.bGuardar.setOnClickListener {
            val nombre = binding.tiet1.text.toString()
            val contrasena = binding.tiet2.text.toString()
            var usuario = Usuario(nombre, contrasena)

            val sharedPreference = getSharedPreferences("preferencias", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("nombre", usuario.nombre)
            editor.putString("contrasena", usuario.contrasena)

            editor.apply()
        }

    }
}