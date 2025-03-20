package com.example.up.Domain.utils

import android.text.TextUtils

/**  isEmailValid() проверяет, является ли данная строка допустимым адресом электронной почты */

fun String.isEmailValid () : Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

