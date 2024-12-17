package com.example.ejercicio18

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class UsuarioDao {

    @Query("SELECT * FROM usuario")
    abstract fun listar(): List<Usuario>?

    @Query("SELECT * FROM usuario WHERE id = :id")
    abstract fun recuperarUsuario(id: Int): Usuario?

    @Insert
    abstract fun insertar(usuario: Usuario)

    @Delete
    abstract fun borrar(usuario: Usuario)

    @Update
    abstract fun actualizar(usuario: Usuario)
}