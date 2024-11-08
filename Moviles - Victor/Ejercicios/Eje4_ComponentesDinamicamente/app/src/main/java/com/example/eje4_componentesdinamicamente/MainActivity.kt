package com.example.eje4_componentesdinamicamente

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eje4_componentesdinamicamente.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var numeros: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b1.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b1.text.toString())
        }
        binding.b2.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b2.text.toString())
        }
        binding.b3.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b3.text.toString())
        }
        binding.b4.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b4.text.toString())
        }
        binding.b5.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b5.text.toString())
        }
        binding.b6.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b6.text.toString())
        }
        binding.b7.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b7.text.toString())
        }
        binding.b8.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b8.text.toString())
        }
        binding.b9.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b9.text.toString())
        }
        binding.b0.setOnClickListener {
            binding.etnpContrasenia.text.append(binding.b0.text.toString())
        }

        binding.bValidar.setOnClickListener {
            if (binding.etnpContrasenia.text.toString() == "1234") {
                binding.tvValidaInvalida.text = "Contraseña válida"
            } else {
                binding.tvValidaInvalida.text = "Contraseña inválida"
            }
        }

        binding.bBorrar.setOnClickListener {
            binding.etnpContrasenia.text.clear()
        }

        binding.ibDado.setOnClickListener {
            numeros.shuffle()
            binding.b1.text = numeros[0]
            binding.b2.text = numeros[1]
            binding.b3.text = numeros[2]
            binding.b4.text = numeros[3]
            binding.b5.text = numeros[4]
            binding.b6.text = numeros[5]
            binding.b7.text = numeros[6]
            binding.b8.text = numeros[7]
            binding.b9.text = numeros[8]
            binding.b0.text = numeros[9]

        }

        binding.cbMostrar.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.tvMuestra.text = binding.etnpContrasenia.text.toString()
            }else{
                binding.tvMuestra.text = ""
            }
        }

    }
}