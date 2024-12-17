package com.example.ejercicio18

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
public abstract class BD: RoomDatabase() {
    public abstract fun usuarioDao(): UsuarioDao?
}