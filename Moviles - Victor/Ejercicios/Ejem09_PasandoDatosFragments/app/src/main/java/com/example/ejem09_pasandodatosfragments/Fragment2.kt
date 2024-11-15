package com.example.ejem09_pasandodatosfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejem09_pasandodatosfragments.databinding.Fragment2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment2Binding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener("datoAEnviar", this) {
            requestKey, bundle ->
            binding.textView2.text = bundle.getString("dato")
        }

        return binding.root
    }


}