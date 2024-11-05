package com.maraloedev.entrenamientosergio

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.entrenamientosergio.databinding.ActivityVista2Binding

class Vista2Activity : AppCompatActivity() {
    lateinit var binding : ActivityVista2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista2)

        binding = ActivityVista2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * bVolver Recoge el nombre del usuario almacenado
         * puente = puente que me lleve desde el objeto actual hasta el MainActivity
         * en el puente cambiame (putExtra(valorPasadodelPrimero,nameUser2))
         */
        binding.bVolver.setOnClickListener {
        val nameUser2 = binding.etNombre.text.toString()

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("NombreUsuario",nameUser2)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}