package com.maraloedev.ejemplo02_trabajandoconclases

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo02_trabajandoconclases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pepe=Persona("Pepe","1234")
        Log.d("depurando","Nombre: ${pepe.nombre} Contraseña: ${pepe.contrasena}")
        pepe.contrasena="5678"
        //var juan=Persona("Juan","5678")
        //juan=pepe
        binding.usuario=pepe


        var pepe2=Persona(edad=25, nombre="Pepe")
        pepe2.contrasena="5678"
        Log.d("depurando", pepe2.toString())
        pepe2.correr()
        Log.d("depurando",pepe2.saludar2(pepe.nombre))

        var datos:ArrayList<Persona> = ArrayList()
        binding.lvListaPersonas.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1, datos)


        binding.bGuardar.setOnClickListener{
            var usuario:Persona=Persona(binding.tietNombre.text.toString(),binding.tietContrasena.text.toString(), binding.tietEdad.text.toString().toInt())
            Log.d("depurando", usuario.toString())
            (binding.lvListaPersonas.adapter as ArrayAdapter<Persona>).add(usuario)

            var personaVacia:Persona=Persona()
            binding.usuario=personaVacia

        }

    }
}