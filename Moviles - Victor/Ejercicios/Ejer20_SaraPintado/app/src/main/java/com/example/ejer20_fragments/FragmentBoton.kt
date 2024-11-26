package com.example.ejer20_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejer20_fragments.databinding.FragmentBotonBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBoton.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBoton : Fragment() {

    lateinit var  binding: FragmentBotonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBotonBinding.inflate(inflater, container, false)
        return binding.root
    }
}