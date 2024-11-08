package com.example.eje03_spinnerlistview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eje03_spinnerlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lista:ArrayList<String> = ArrayList()

        binding.bBorrar.setOnClickListener(){
            //No funciona
            lista.dropLast(1)
            binding.lvLista.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista)
        }

        binding.bAniadir.setOnClickListener(){
            lista.add(binding.ptDatoIntroducir.text.toString())
            binding.lvLista.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lista)
        }


    }
}