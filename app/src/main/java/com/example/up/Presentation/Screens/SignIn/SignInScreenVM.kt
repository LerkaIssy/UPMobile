package com.example.up.Presentation.Screens.SignIn


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.up.Domain.Constant
import com.google.android.gms.auth.api.Auth
import kotlinx.coroutines.launch


class SignInScreenVM : ViewModel() {

    fun onSignInEmailPassword(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try {
                val user = Constant.supabase.Auth.signInWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constants.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            } catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }
        }
    }

}