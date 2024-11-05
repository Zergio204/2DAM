package com.example.examenzumos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenzumos.databinding.ActivityMain3Binding
import com.example.examenzumos.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main3)

        val papaya = Zumo("Papaya", 1.0)
        val sandia = Zumo("Sandia", 2.0)
        val naranja = Zumo("Naranja", 3.0)
        val arandano = Zumo("Arandano", 4.0)

        binding.ibPapaya.setOnClickListener(){
            setResult(RESULT_OK, intent.putExtra(papaya.nombre, papaya.precio))
            Snackbar.make(binding.root, "${papaya.nombre}",Snackbar.LENGTH_SHORT)
        }
        binding.ibSandia.setOnClickListener(){
            setResult(RESULT_OK, intent.putExtra(sandia.nombre, sandia.precio))
            Snackbar.make(binding.root, "${sandia.nombre}",Snackbar.LENGTH_SHORT)

        }
        binding.ibNaranja.setOnClickListener(){
            setResult(RESULT_OK, intent.putExtra(naranja.nombre, naranja.precio))
            Snackbar.make(binding.root, "${naranja.nombre}",Snackbar.LENGTH_SHORT)
        }
        binding.ibArandano.setOnClickListener(){
            setResult(RESULT_OK, intent.putExtra(arandano.nombre, arandano.precio))
            Snackbar.make(binding.root, "${arandano.nombre}",Snackbar.LENGTH_SHORT)
        }
        binding.bFinalizar.setOnClickListener(){


        }


    }
}