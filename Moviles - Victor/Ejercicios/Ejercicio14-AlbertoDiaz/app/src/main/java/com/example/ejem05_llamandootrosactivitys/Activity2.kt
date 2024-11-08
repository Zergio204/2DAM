package com.example.ejem05_llamandootrosactivitys

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem05_llamandootrosactivitys.databinding.Activity2Binding
import com.example.ejem05_llamandootrosactivitys.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {
    lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var contador:Contador = Contador(0);

        binding.buttonFINALIZAR.setOnClickListener(){
            setResult(RESULT_OK, intent.putExtra("cont", contador))
            finish()
        }

        binding.buttonCONTAR.setOnClickListener(){
            contador.contador++;
            binding.textViewContador2.text = Integer.toString(contador.contador);
        }
    }
}