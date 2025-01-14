package com.example.ejemconexionsockets

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemconexionsockets.databinding.ActivityMainBinding
import java.io.ObjectOutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        lateinit var oos:ObjectOutputStream

        binding.bConectar.setOnClickListener {

            var socket:Socket = Socket("172.26.8.21", 4444)
            oos = ObjectOutputStream(socket.getOutputStream())

            binding.bEnviar.isEnabled = true
        }

        binding.bEnviar.setOnClickListener {

            var m:Mensaje = Mensaje(binding.tietTexto.text.toString());

            oos.writeObject(m)
            binding.tietTexto.text!!.clear()
        }

    }
}