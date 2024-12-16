package com.example.ejem16_bd

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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

        binding.bRecuperarPrimero.setOnClickListener {
            val persona = personaDAO?.recuperarUsuario(1)
            binding.persona = persona
        }

        binding.bListar.setOnClickListener {
            val personas = personaDAO?.listar()
            val adaptador = ArrayAdapter(this, R.layout.simple_list_item_1, personas!!)
            binding.lvPersonas.adapter = adaptador
        }

        binding.bBorrar.setOnClickListener {
            val id = binding.tietId.text.toString().toInt()
            val persona = personaDAO?.recuperarUsuario(id)
            personaDAO?.eliminar(persona!!)
        }

        binding.bActualizar.setOnClickListener {
            val id = binding.tietId.text.toString().toInt()
            val persona = personaDAO?.recuperarUsuario(id)
            persona?.nombre = binding.tietNombre.text.toString()
            persona?.edad = binding.tietEdad.text.toString().toInt()
            persona?.direccion = binding.tietDireccion.text.toString()

            personaDAO?.actualizar(persona!!)

        }

        binding.lvPersonas.setOnItemClickListener{
            adapterView, view, position, id ->
            val persona = adapterView.getItemAtPosition(position) as Persona
            binding.persona = persona

            binding.tietId.setText(persona.id.toString())

        }


    }
}