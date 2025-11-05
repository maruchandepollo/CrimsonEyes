package com.example.crimsoneyes.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.crimsoneyes.model.Usuario
<<<<<<< HEAD
import kotlinx.coroutines.flow.Flow
=======
>>>>>>> 32cbb9d (Ready)

@Dao
interface UsuarioDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: Usuario): Long

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)

<<<<<<< HEAD
    @Query("SELECT * FROM usuarios WHERE username = :username")
    suspend fun findByUsername(username: String): Usuario?
=======
    @Query("SELECT * FROM usuarios WHERE nombre = :nombre")
    suspend fun findByUsername(nombre: String): Usuario?
>>>>>>> 32cbb9d (Ready)
}
