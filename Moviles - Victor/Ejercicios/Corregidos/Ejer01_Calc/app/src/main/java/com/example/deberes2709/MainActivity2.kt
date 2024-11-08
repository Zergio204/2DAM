package com.example.deberes2709

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.deberes2709.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var num1:Int = 0
    var num2:Int = 0
    var cont: Int = 0
    var simb:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var num: Int = 11

        var listener: View.OnClickListener = View.OnClickListener { boton->
            num=(boton as Button).text.toString().toInt()
            asignarNumero(num)
            binding.resultado.text = num.toString()
        }
            

        binding.button.setOnClickListener(listener)
        binding.button2.setOnClickListener(listener)
        binding.button3.setOnClickListener(listener)
        binding.button4.setOnClickListener(listener)
        binding.button5.setOnClickListener(listener)
        binding.button6.setOnClickListener(listener)
        binding.button7.setOnClickListener(listener)
        binding.button8.setOnClickListener(listener)
        binding.button9.setOnClickListener(listener)
        binding.button10.setOnClickListener() {
            simb = "+"
            binding.resultado.text = simb
        }

        binding.button11.setOnClickListener {
            if (simb == "+") {
                val result = num1 + num2
                binding.resultado.text = result.toString()
            } else if (simb == "-") {
                val result = num1 - num2
                binding.resultado.text = result.toString()
            }
            num1 = 0
            num2 = 0
            cont = 0
            simb = ""
        }

        binding.button12.setOnClickListener() {
            simb = "-"
            binding.resultado.text = simb
        }

        binding.button13.setOnClickListener() {
            simb = ""
            binding.resultado.text = simb
        }
    }

    private fun asignarNumero(num: Int) {
        if (cont == 0) {
            num1 = num
            cont++
        } else {
            num2 = num
        }
    }
}