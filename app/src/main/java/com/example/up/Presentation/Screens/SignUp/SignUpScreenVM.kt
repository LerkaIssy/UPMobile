package com.example.up.Presentation.Screens.SignUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.up.Domain.Constant
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class SignUpScreenVM:ViewModel() {

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
            }

        }
    }
}