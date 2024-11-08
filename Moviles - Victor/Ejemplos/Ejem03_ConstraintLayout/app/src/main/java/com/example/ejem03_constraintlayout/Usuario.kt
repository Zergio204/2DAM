package com.example.ejem03_constraintlayout

class Usuario {

    var nombre:String
    var apellido1:String
    var apellido2:String

    constructor(nombre: String, apellido1: String,apellido2: String){
        this.nombre = nombre
        this.apellido1 = apellido1
        this.apellido2 = apellido2
    }

    override fun toString(): String {
        return "Usuario(nombre='$nombre', apellido1='$apellido1', apellido2='$apellido2')"
    }


}