package com.example.ejem16_bd

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.ejem16_bd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val basedatos: BD =
            Room.databaseBuilder(this, BD::class.java, "bdPersonas").allowMainThreadQueries()
                .build()
        val personaDAO = basedatos.personaDao()

        binding.bInsertar.setOnClickListener {
            val persona = Persona(binding.tietNombre.text.toString(),
                                    binding.tietEdad.text.toString().toInt(),
                                    binding.tietDireccion.text.toString())
            Log.d("Persona", persona.toString())
            personaDAO?.insertar(persona)
        }

    }
}