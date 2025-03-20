package com.example.up.Presentation.Screens.SignIn


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.up.Domain.Constant
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.launch


/**
 * Этот код определяет класс SignInScreenVM на Kotlin, использующей архитектуру MVVM (Model-View-ViewModel).
 * Он управляет состоянием пользовательского интерфейса и результатом операции входа пользователя
 * */

class SignInScreenVM : ViewModel() {

    // Основная функция, которая обрабатывает процесс входа в систему пользователем
    fun onSignInEmailPassword(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try {
                val user = Constant.supabase.auth.signInWith(Email){
                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constant.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            } catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }
        }
    }

}