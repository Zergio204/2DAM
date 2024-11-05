package com.example.ejem05_llamandootrosactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem05_llamandootrosactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
                if (result.resultCode== RESULT_OK){
                    val contador = result.data?.getParcelableExtra("cont", Contador::class.java).toString()
                    binding.textViewContador.text = contador?.toString()
                } else if (result.resultCode== RESULT_CANCELED){
                    binding.textViewContador.text= "No viene contador"
                }
        }

        binding.bIrActivity2.setOnClickListener(){
            var miIntent: Intent = Intent(this, Activity2::class.java)
            launcher.launch(miIntent)
        }

        binding.layoutBlue.setOnTouchListener { view, motionEvent ->
            var x:Float = motionEvent.x;
            var y:Float = motionEvent.y;
            binding.textViewCoordenadas.text = "${x} +  + ${y}";
            false;
        }
    }
}