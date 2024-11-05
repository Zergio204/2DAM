package com.example.ejem01_componentesbasicos

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem01_componentesbasicos.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var listaNombres:ArrayList<String> = ArrayList()
        listaNombres.add("Juan");
        listaNombres.add("Pedro");
        binding.lvListaNombres.adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombres)


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        /*val boton:Button=findViewById<Button>(R.id.b_RecuperarDatos)
        boton.setOnClickListener(){
            val nombre:EditText=findViewById<EditText>(R.id.et_NombreUsuario)
            val textoNombre:TextView=findViewById<EditText>(R.id.tv_saludo)
            textoNombre.text="Hola ${nombre.text}"
        }*/

        binding.bRecuperarDatos.setOnClickListener() {
            var estadoCivil: String =
                findViewById<RadioButton>(binding.rgEstadoCivil.checkedRadioButtonId).text.toString()
            binding.tvSaludo.text = "Hola ${binding.etNombreUsuario.text} " + estadoCivil + ", color favorito: ${binding.spColores1.selectedItem}"

            var nombreIntroducido:String = binding.etNombreUsuario.text.toString()
            listaNombres.add(nombreIntroducido)
            (binding.lvListaNombres.adapter as ArrayAdapter<String>).add(nombreIntroducido)
        }

        binding.swActivar.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener() { buttonView, isChecked ->
            if (isChecked)
                binding.bRecuperarDatos.isEnabled = false
            else
                binding.bRecuperarDatos.isEnabled = true
        })

        binding.spColores1.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                Log.d("depurando", "Seleccionado: ${binding.spColores1.selectedItem}")
                //val temp:String=(parent as ArrayAdapter<String>).getItem(position)
                //Log.d("depurando", "Seleccionado: ${temp}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("depurando", "Nada seleccionado")
            }
        }

        //Metemos los datos del desplegable 2 con un adaptador
        var datos_desplegable= arrayOf("Rojo", "Verde", "Azul", "Amarillo")
            binding.spColores2.adapter=ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos_desplegable)



    }
}