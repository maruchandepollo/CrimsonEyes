package com.example.crimsoneyes.controller

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crimsoneyes.model.Usuario
import com.example.crimsoneyes.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class RegisterViewModel(private val repository: UsuarioRepository): ViewModel() {
    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val registerState: StateFlow<RegisterState> = _registerState.asStateFlow()

<<<<<<< HEAD
    fun register(username: String,  password: String) {
        viewModelScope.launch {
            try {
                _registerState.value = RegisterState.Loading

                //verificar si el usuario ya existe
                val existingUser = repository.findByUsername(username)
                if(existingUser != null) {
                    _registerState.value = RegisterState.Error("El nombre de usuario ya existe")
                    return@launch
                }
                val newUser = Usuario(
                    username = username,
                    password = password
                )
                val userId = repository.insert(newUser)

                if(userId > 0) {
                    Log.d("RegisterViewModel", "Usuario registrado exitosamente: $username")
                    _registerState.value = RegisterState.Success(newUser.copy(id = userId))
                } else {
                    _registerState.value = RegisterState.Error("Error al crear el usuario")
=======
    fun register(nombre: String, email: String,  password: String, rut: String) {
        viewModelScope.launch {
            try {
                _registerState.value = RegisterState.Loading
                // Registrar vía backend
                val newUser = Usuario(
                    nombre = nombre,
                    email = email,
                    password = password,
                    rut = rut

                )

                val success = repository.register(newUser)
                if (!success) {
                    _registerState.value = RegisterState.Error("Error al registrar en el servidor")
                    return@launch
                }

                // Insertar localmente para mantener BD coherente
                val userId = repository.insert(newUser)
                if(userId > 0) {
                    Log.d("RegisterViewModel", "Usuario registrado exitosamente: $nombre")
                    _registerState.value = RegisterState.Success(newUser.copy(id = userId))
                } else {
                    _registerState.value = RegisterState.Error("Registrado en servidor pero error al guardar localmente")
>>>>>>> 32cbb9d (Ready)
                }
            }catch(ex: Exception) {
                Log.e("RegisterViewModel", "Error en registro..", ex)
                _registerState.value = RegisterState.Error("Error al registrar: ${ex.message}")
            }
        }
    }

    fun resetState() {
        _registerState.value = RegisterState.Idle
    }
}
