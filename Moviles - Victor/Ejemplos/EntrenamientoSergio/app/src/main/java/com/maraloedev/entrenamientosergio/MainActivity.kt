package com.maraloedev.entrenamientosergio

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.entrenamientosergio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creas una lista mutable (Le puedes poner varios datos, y eliminarlos (como un AL))
        val listaUsuarios: MutableList<Usuario> = mutableListOf()

        //Creo objeto usuario
        val user = Usuario("Sergio")

        //pongo por defecto el usuario, que esta en activity en una variable llamada @{user.nombre}
        binding.usuario = user

        /**
         * boton listar lo que hace es:
         *                  RECUPERAR EL NOMBRE ACTUAL QUE HAY EN EL EDIT TEXT
         *                  CREO UN NEW USER
         *                  LO AÑADO A LA LISTA
         *                  CREO UN ARRAY ADAPTER PARA AÑADIR UN TIPO DE LISTA A LA LISTA, CON LO SIGUIENTE
         *                  ArrayAdapter(OBJETO ACTUAL, TIPO DE LISTA A MOSTRAR, lista a utilizar)
         *                  ADAPTO EL LISTVIEW A LA LISTA DESEADA
         *                  NOTIFICO QUE SE HA CAMBIADO
         */
        binding.bListar.setOnClickListener {

            val usuarioName = binding.etNombreUsuario.text

            val newUser = Usuario(usuarioName.toString())
            listaUsuarios.add(newUser)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUsuarios)
           binding.lvDatos.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        binding.lvDatos.setOnItemClickListener { adapterView, view, i, l ->
            val usuarioName = binding.etNombreUsuario.text
            //      Toast.makeText(this,("EL NOMBRE ES $usuarioName"),Toast.LENGTH_LONG).show()
            Snackbar.make(binding.root, "EL NOMBRE ES $usuarioName", Snackbar.LENGTH_LONG).show()
        }


        /**
         * CREO UN LAUNCHER REGISTRANDO LA ACTIVIDAD ACTUAL
         * SI LA ACTIVIDAD ESTA OK, ME DAS (GET añade una clave, que es NombreUsuario (Que se va a usar en el Activity2))
         * EL RESULTADO DEL DATO ACTUAL
         */
        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == RESULT_OK) {

                    binding.etNombreUsuario.setText(result.data?.getStringExtra("NombreUsuario"))
                }
            }

        /**
         * boton bIrAlSegundoActivity
         * creas un puente, donde el puente va a ir desde el objeto actual, hasta Vista2Activity
         * Ejecutame el puente intent
         */
        binding.bIrAlSegundoActivity.setOnClickListener {
            val puente = Intent(this,Vista2Activity::class.java)
            launcher.launch(puente)

        }
    }
}