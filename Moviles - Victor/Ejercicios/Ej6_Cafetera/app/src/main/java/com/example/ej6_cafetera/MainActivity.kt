package com.example.ej6_cafetera

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ej6_cafetera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        var dinero:Double = 0.0

        binding.swOnOff.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                binding.swOnOff.text = "ON"
            }else{
                binding.swOnOff.text = "OFF"
            }
        }
        
        binding.bServirCafe.setOnClickListener(){
            if (binding.swOnOff.text == "ON"){
                var cafeSeleccionado:String = binding.spSelectorCafe.selectedItem.toString()
                if(binding.cbAzucar.isChecked){
                    var extraAzucar:Boolean = true
                    binding.tvCafeServido.text = "Servido " + cafeSeleccionado + " con extra de azucar."
                    dinero = dinero + 0.5
                }else{
                    binding.tvCafeServido.text = "Servido " + cafeSeleccionado
                }

                dinero = dinero + 1

                binding.tvRecaudado.text = "Lleva recaudado: " + dinero.toString() + "€"
            }

        }

    }
}