package com.example.ejer15

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import com.example.ejer15.databinding.ActivityMainBinding
import java.util.Locale

/*
Ejer 15. Repaso
El Ministerio de Robología del gobierno de España encarga al centro Gregorio Fernández la
realización de una aplicación móvil para la recogida de votos para las próximas elecciones.
- activity2, aparecerá un desplegable con los partidos políticos existentes: Tras seleccionar un partido y pulsar en Votar, se volverá al
primer activity donde en un TextView inferior (tv_estadisticas) se irán mostrando las estadísticas de los votos
realizados:
PSOE: x
Podemos: w
IU: y
PP: z
*/

class Activity2 : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bVotar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}