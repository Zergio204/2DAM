package com.example.ejemconexionsockets;
import java.io.Serializable;

public class Mensaje implements Serializable {

    String texto;

    public Mensaje() {
    	
    }
    
    public Mensaje(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
