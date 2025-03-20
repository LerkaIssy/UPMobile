package com.example.up.Presentation.Screens.SignIn


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.up.Domain.Constant
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.launch


class SignInScreenVM : ViewModel() {

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