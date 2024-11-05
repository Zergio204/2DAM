package com.asierso.componentesejer05

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asierso.componentesejer05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var spUsuariosArray: ArrayList<Usuario>
    private var puedeAgregar: Boolean = true

    //@SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.usuario = Usuario()

        spUsuariosArray = arrayListOf()
        spUsuariosArray.add(Usuario("Juan", "Perez"))
        spUsuariosArray.add(Usuario("Ana", "Lopez"))

        var adaptador=ArrayAdapter<Usuario>(this, android.R.layout.simple_spinner_item,
            spUsuariosArray)
        binding.spUsuarios.adapter =adaptador


        /*binding.llyTouchable.setOnTouchListener(object: View.OnTouchListener {
            override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
                when (motionEvent?.action) {
                    MotionEvent.ACTION_UP -> {
                        puedeAgregar = true
                    }

                    MotionEvent.ACTION_MOVE -> {
                        if (puedeAgregar) {
                            spUsuariosArray.add(Usuario(
                                binding.edNombre.text.toString(),
                                binding.edPassword.text.toString()))

                            (binding.spUsuarios.adapter as ArrayAdapter<*>).notifyDataSetChanged()
                        }
                        puedeAgregar = false
                    }
                }

                return true
            }
        })*/


        binding.llyTouchable.setOnTouchListener { view, motionEvent ->

            when (motionEvent.action) {
                MotionEvent.ACTION_UP -> {
                    puedeAgregar = true
                }

                MotionEvent.ACTION_MOVE -> {
                    if (puedeAgregar) {
                        /* Opción 1. Añado los datos al ArrayList directamente, por tanto tengo que
                        notificar al adaptador que los datos han cambiado con notifyDataSetChanged

                        spUsuariosArray.add(Usuario(

                            binding.edNombre.text.toString(),
                            binding.edPassword.text.toString()))

                        (binding.spUsuarios.adapter as ArrayAdapter<*>).notifyDataSetChanged()
                         */
                         //Opción 2. Añado los datos al adaptador, por tanto no tengo que notificar
                        adaptador.add(Usuario(
                            binding.tietNombre.text.toString(),
                            binding.tietContrasena.text.toString()))
                        binding.tietNombre.text?.clear()
                        binding.tietContrasena.text?.clear()
                    }
                    puedeAgregar = false
                }
            }

            return@setOnTouchListener true
        }


        binding.spUsuarios.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.usuario = spUsuariosArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se necesita
            }
        }


    }
}