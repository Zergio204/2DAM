package com.example.ejem03_constraintlayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.ejem03_constraintlayout.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bEnviar.setOnClickListener(){
            var nombre:String = binding.tietNombre.text.toString()
            var apell1:String = binding.tietApellido1.text.toString()
            var apell2:String = binding.tietApellido2.text.toString()

            var u = Usuario(nombre, apell1, apell2);

            Log.d("depurando", u.toString())

        }

        val listenerTeclado:TextWatcher = object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(teit_editado: Editable?) {
                var cadena:String = teit_editado.toString()
                Log.d("depurando",cadena)

                validarCampos(binding.tilNombre, binding.tietNombre){texto -> texto.length>10}
                validarCampos(binding.tilApellido1, binding.tietApellido1){texto -> texto.length>5}
                validarCampos(binding.tilApellido2, binding.tietApellido2){texto -> texto.length>2}
            }
        }

        binding.tietNombre.addTextChangedListener()
        binding.tietApellido1.addTextChangedListener()
        binding.tietApellido2.addTextChangedListener()

    }

    private fun validarCampos(layoutCampo:TextInputLayout, campo: TextInputEditText, condicion: (String)->Boolean){
        if (condicion(campo.text.toString())){
            campo.error="Error"
            layoutCampo.error = "No puede ser vacio"
        }else{
            campo.error=null
            layoutCampo.error = null
        }
    }

}