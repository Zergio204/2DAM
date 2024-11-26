package com.example.ejem10_datosdefragmentaactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 3ª forma de pasar datos de Fragment a Activity
class Dato : ViewModel() {
    var dato  = MutableLiveData<String>()


}