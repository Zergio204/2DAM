package com.example.ejem02_variables

class Persona (var nombre:String, var edad:Int, var sexo:Boolean) {

    fun saludar(): String {
        return nombre + " tiene " + edad + " años y es de sexo " + sexo
    }

}