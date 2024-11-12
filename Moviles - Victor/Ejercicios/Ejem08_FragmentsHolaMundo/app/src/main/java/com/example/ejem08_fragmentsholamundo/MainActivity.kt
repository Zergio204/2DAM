package com.example.ejem08_fragmentsholamundo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem08_fragmentsholamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bCargarFragments.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainerView, FragmentInicial())
                commit()
            }

        }

        binding.bReemplazarFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, Fragment_2())
                commit()
            }
        }



    }
}