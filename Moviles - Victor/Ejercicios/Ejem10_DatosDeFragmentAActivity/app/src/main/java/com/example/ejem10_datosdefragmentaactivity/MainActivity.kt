package com.example.ejem10_datosdefragmentaactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.ejem10_datosdefragmentaactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MiFragment.EnviandoDatos {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var c:Contador= ViewModelProvider(this).get(Contador::class.java)
        binding.tvContador.text=c.contador.toString()

        // 1ª forma de pasar datos de Fragment a Activity
        /*supportFragmentManager.setFragmentResultListener("datoAEnviar", this){
            key, bundle ->
            binding.tvDatoRecibidoFragment.text = bundle.getString("dato")
        }*/

        // 3ª forma con ViewModel
        /*var dato=ViewModelProvider(this).get(Dato::class.java)
        dato.dato.observe(this, {
            binding.tvDatoRecibidoFragment.text = it
        })*/


        binding.bIncrementar.setOnClickListener(){
            c = ViewModelProvider(this).get(Contador::class.java)
            c.incrementar()
            binding.tvContador.text=c.contador.toString()
        }



    }

    // 2ª forma de pasar datos de Fragment a Activity con interfaces
    override fun enviarDatos(datos: String) {
        binding.tvDatoRecibidoFragment.text = datos
    }






}