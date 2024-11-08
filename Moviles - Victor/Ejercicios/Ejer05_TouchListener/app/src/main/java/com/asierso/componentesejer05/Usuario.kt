package com.asierso.componentesejer05

class Usuario (var nombre : String = "", var password : String = "") {
    override fun toString(): String {
        return nombre
    }
}