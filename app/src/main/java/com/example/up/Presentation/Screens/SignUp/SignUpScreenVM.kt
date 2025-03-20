package com.example.up.Presentation.Screens.SignUp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.up.Domain.Constant
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email


/**
 * Этот код определяет класс SignUpScreenVM на Kotlin, использующей архитектуру MVVM (Model-View-ViewModel).
 * Он управляет состоянием пользовательского интерфейса и результатом операции регистрации пользователя
 * */

class SignUpScreenVM:ViewModel() {

    // Основная функция, которая обрабатывает процесс регистрации в системе пользователя
    fun onSignUpEmail(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try{
                var  user =  Constant.supabase.auth.signUpWith(Email) {

                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constant.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            }
            catch (e: Exception) {
                println("Error")
                println(e.message.toString())
                Log.d("signUp", e.message.toString())

            }

        }
    }
}