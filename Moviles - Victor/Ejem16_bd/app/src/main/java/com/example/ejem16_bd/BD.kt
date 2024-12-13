package com.example.ejem16_bd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persona::class], version = 1)
public abstract class BD : RoomDatabase() {

    public abstract fun personaDao(): PersonaDao?

}