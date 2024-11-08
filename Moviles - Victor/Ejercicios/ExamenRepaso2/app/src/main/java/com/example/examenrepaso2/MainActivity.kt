package com.example.examenrepaso2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenrepaso2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var listaAlumnos: MutableList<Alumno> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAlumnos)
        binding.lvAlumnos.adapter = adaptador

        var alumnoDefault:Alumno = Alumno("")

        var cadenaPersonalizada:String = getResources().getQuantityString(R.plurals.alumnos, listaAlumnos.size, listaAlumnos.size);
        binding.tvContadorAlumno.setText(cadenaPersonalizada);

        binding.bAnadir.setOnClickListener(){
            var hombre =binding.rbHombre.isChecked

            if(!binding.etNombre.text.toString().equals("")) {
                var alumno: Alumno = Alumno(binding.etNombre.text.toString(), hombre)
                listaAlumnos.add(alumno)
                adaptador.notifyDataSetChanged()
                binding.alumno=alumnoDefault
            }

            var cadenaPersonalizada:String = getResources().getQuantityString(R.plurals.alumnos, listaAlumnos.size, listaAlumnos.size);
            binding.tvContadorAlumno.setText(cadenaPersonalizada);




        }

        binding.lvAlumnos.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "${listaAlumnos[i].nombre} es ${listaAlumnos[i].hombre}",
                Toast.LENGTH_SHORT).show()
        }

        binding.tbActivado.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                binding.bAnadir.isEnabled=false
            }else{
                binding.bAnadir.isEnabled=true
            }
        }
    }
}