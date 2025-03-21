package com.example.up.Presentation.Screens.Catalog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.up.Domain.Constant
import com.example.up.Domain.models.Category
import com.example.up.Domain.models.Products
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatalogVM:ViewModel() {
    var categories by mutableStateOf<List<Category>>(listOf())
    var products by mutableStateOf<List<Products>>(listOf())
    @Composable
    fun ProductsList(){
        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO){
                products= Constant.supabase.from("products").select().decodeList<Products>()
            }
        }
    }
    @Composable
    fun CategoryList(){
        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO){
                categories= Constant.supabase.from("categories").select().decodeList<Category>()
            }
        }
    }
}