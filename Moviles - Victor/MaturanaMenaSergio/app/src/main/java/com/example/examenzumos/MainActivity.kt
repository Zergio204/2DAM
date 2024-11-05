package com.example.examenzumos

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenzumos.databinding.ActivityMainBinding
import com.example.examenzumos.Usuario

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        //var launcher = registerForActivityResult(ActivityResultContracts, intent,)

        val user = Usuario("palo_valdes", 1234)
        binding.usuario = user

        binding.bLogin.setOnClickListener(){
            if (binding.tietLogin.toString().equals(user.nombre) and binding.tietPassword.equals(user.contrasena)){
                var intent:Intent = Intent(this,MainActivity3::class.java)

            }
        }


    }
}