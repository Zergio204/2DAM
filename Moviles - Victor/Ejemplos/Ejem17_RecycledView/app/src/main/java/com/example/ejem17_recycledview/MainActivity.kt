package com.example.ejem17_recycledview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem17_recycledview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persona1 = Persona(ContextCompat.getDrawable(this, R.drawable.foto1)!!,"Victor",23,"983 44 22 33")
        val persona2 = Persona(ContextCompat.getDrawable(this, R.drawable.foto2)!!,"Zergio",20,"058 47 25 62")
        val persona3 = Persona(ContextCompat.getDrawable(this, R.drawable.foto3)!!,"Piter",34,"798 54 22 87")

        val listaPersonas = listOf(persona1,persona2,persona3)

        binding.rvVistaDatos.adapter = AdaptadorPersona(listaPersonas)

    }
}