package com.eirmarse.ejercicio2

class Persona(var nombre:String,var soltero:Boolean=true, var deportes:List<String> = emptyList()
              , var edad:Int=0) {
    override fun toString(): String {
        return "Persona(nombre='$nombre', soltero=$soltero, deportes=$deportes, edad=$edad)"
    }
}