package com.example.eje02_componentesbasicosii

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eje02_componentesbasicosii.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bGuardar.setOnClickListener{

            var nombre = binding.ptNombre.text.toString()
            var estadoCivil = findViewById<RadioButton>(binding.rgEstadoCivil.checkedRadioButtonId).text
            var ciudad = binding.spCiudad.selectedItem.toString()

            /*
            var futbol = binding.cbFutbol.text.toString()
            var baloncesto = binding.cbBaloncesto.text
            var tenis = binding.cbTenis.isActivated

             */

            var fraseFinal = "Nombre: $nombre, Estado Civil: $estadoCivil, Ciudad: $ciudad"

            Log.d("depurado", fraseFinal)

        }


    }
}