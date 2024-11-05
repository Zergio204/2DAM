package com.maraloedev.ejemplo02_trabajandoconclases

import android.util.Log

//open para poder heredar de la clase
open class SerHumano {

    fun saludar(){
        Log.d("depurando", "hola")
    }
    fun saludar2(nombre:String):String{
        return "Hola $nombre"
    }

}