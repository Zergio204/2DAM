package com.example.examenrepaso2

class Alumno(var nombre: String, var hombre: Boolean?) {

    override fun toString(): String {
        return "$nombre"
    }

    constructor(nombre: String) : this(nombre, null)
}