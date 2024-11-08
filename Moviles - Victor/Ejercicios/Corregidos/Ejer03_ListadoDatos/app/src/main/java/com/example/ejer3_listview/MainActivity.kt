package com.example.ejer3_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ejer3_listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvDatos.adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf<String>())

        binding.bAniadir.setOnClickListener(){
            //Actualizar lista de nombres
            var nombreIntroducido:String=binding.dtNombreDato.text.toString()
            (binding.lvDatos.adapter as ArrayAdapter<String>).add(nombreIntroducido)
            //Borrar texto
            binding.dtNombreDato.text.clear()
        }

        binding.bBorrar.setOnClickListener(){
            //Último nombre
            val ultimoNombre= binding.lvDatos.adapter.getItem(binding.lvDatos.adapter.count -1) as String
            //Borrar último nombres
            (binding.lvDatos.adapter as ArrayAdapter<String>).remove(ultimoNombre)
        }

        binding.lvDatos.setOnItemClickListener{ parent, view, position, id ->
            //Obtener nombre
            val nombreSelec= parent.getItemAtPosition(position) as String
            //Eliminar nombre
            (binding.lvDatos.adapter as ArrayAdapter<String>).remove(nombreSelec)
        }
    }
}