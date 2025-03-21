package com.example.up.Presentation.Screens.MainPage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.up.Domain.Constant
import com.example.up.Domain.models.Category
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainPageVM:ViewModel() {
    var categories by mutableStateOf<List<Category>>(listOf())

    @Composable
    fun CategoryList(){
        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO){
                categories=Constant.supabase.from("categories").select().decodeList<Category>()
            }
        }
    }
}