package com.eirmarse.ejercicio2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eirmarse.ejercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //evento para la captura del texto en Introduce tu nombre

        binding.etNombre.setOnKeyListener { componentePadre, codigoLetra, EventoProducido ->
            Log.d("depurando", "Ha pulsado " + codigoLetra)
            true
        }
        
        binding.lyPadreMarron.setOnTouchListener { view, motionEvent ->
            Log.d("depurando","Ha pulsado el Padre")
            false
        }

        binding.lyHijoVerde.setOnTouchListener { view, motionEvent ->
            Log.d("depurando","Ha pulsado el Hijo")
            binding.tvHijo.text=motionEvent.x.toString()+","+motionEvent.y.toString()


            true
        }

        

        var pepe: Persona = Persona("Pepe",true, listOf("Fútbol","Baloncesto"),18)
        binding.usuario = pepe

        binding.bGuardar.setOnClickListener {

            Log.d("depurando",pepe.toString())

            var listaDeportes:ArrayList<String> = arrayListOf()
            if (binding.cbTenis.isChecked){
                listaDeportes.add("Tenis")
            }
            if (binding.cbFutbol.isChecked){
                listaDeportes.add("Fútbol")
            }
            if (binding.cbBaloncesto.isChecked){
                listaDeportes.add("Baloncesto")
            }

            var usuario:Persona=Persona(binding.etNombre.text.toString(),edad=binding.etEdad.text
                .toString().toInt(),soltero=binding.rbSoltero.isChecked,deportes=listaDeportes)
            Log.d("depurando", usuario.toString())
            var usuarioVacio:Persona=Persona("")
            binding.usuario=usuarioVacio

            if (binding.rbSoltero.isChecked) {
                Log.d("depurando", "Soltero")
            } else if (binding.rbCasado.isChecked) {
                Log.d("depurando", "Casado")
            } else {
                Log.d("depurando", "NS/NC")
            }

            Log.d("depurando", "Ciudad: ${binding.spCiudad.selectedItem}")

            if (binding.cbFutbol.isChecked) {
                Log.d("depurando", binding.cbFutbol.text.toString())
            }
            if (binding.cbBaloncesto.isChecked) {
                Log.d("depurando", binding.cbBaloncesto.text.toString())
            }
            if (binding.cbTenis.isChecked) {
                Log.d("depurando", binding.cbTenis.text.toString())
            }
        }
    }
}