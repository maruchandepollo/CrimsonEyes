package com.example.crimsoneyes.model
<<<<<<< HEAD
import androidx.room.Entity
import androidx.room.PrimaryKey
=======

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
>>>>>>> 32cbb9d (Ready)

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
<<<<<<< HEAD
    val username: String,
    val password: String,

    )
=======
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("rut") val rut: String,
    @SerializedName("nombre") val nombre: String


)
>>>>>>> 32cbb9d (Ready)
