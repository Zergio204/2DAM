package com.maraloedev.ejemplo02_trabajandoconclases

//class Persona (var nombre:String, var contrasena:String ){

class Persona (var nombre:String):SerHumano(),Atleta{
    var contrasena:String = ""
    var edad:Int? = null

    constructor(nombre:String, contrasena:String) : this(nombre){
        this.contrasena = contrasena
    }
    constructor(nombre:String, contrasena:String = "0000", edad:Int) : this(nombre){
        this.edad = edad
    }
    constructor() : this("","")

    override fun toString(): String {
        return "Persona(nombre='$nombre', contrasena='$contrasena', edad=$edad)"
    }

    override fun correr() {
        super.correr()
    }
}