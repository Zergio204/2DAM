package com.example.ejem05_llamandoaotrosactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem05_llamandoaotrosactivitys.databinding.ActivityMainBinding
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bIrActivity2.setOnClickListener {
            var miIntent = Intent(this, Activity2::class.java)
            miIntent.putExtra("dato", binding.tietDato.text.toString())
            startActivity(miIntent)
        }
    }
}