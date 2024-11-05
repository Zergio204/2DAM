package com.maraloedev.ejercicio014_contador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejercicio014_contador.databinding.ActivityContadorBinding

class ContadorActivity : AppCompatActivity() {
    lateinit var binding: ActivityContadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityContadorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var contador = 0

        binding.bContar2.setOnClickListener {
            contador++
            binding.tvCuentaClicks.text = contador.toString()
        }

        binding.bFinalizar.setOnClickListener {
            intent.putExtra("actualizarContador", binding.tvCuentaClicks.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}