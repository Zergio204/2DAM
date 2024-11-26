package com.example.ejem12_navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejem12_navigationcomponent.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    lateinit var binding: Fragment3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment3Binding.inflate(inflater, container, false)
        return binding.root
    }

}