package com.example.up.Presentation.Screens.MainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.Presentation.Screens.SignIn.SignIn
import com.example.up.R


@Composable
// navHost: NavHostController:  Объект для навигации между экранами.
// signUpViewModel: SignUpScreenVM = viewModel() :  ViewModel, управляющий состоянием и логикой экрана регистрации пользователя.
fun MainPage(navHost: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(1f).background(colorResource(R.color.background)), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween){
            IconButton(onClick = {  },

                modifier = Modifier
                    .padding(0.dp,50.dp,0.dp,0.dp).size(50.dp).width(50.dp),

                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(R.color.background))) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Меню", modifier = Modifier.size(30.dp))
            }
            Text(text="Главная", textAlign = TextAlign.Center, fontWeight = FontWeight.W400, fontSize = 32.sp,modifier = Modifier
                .padding(15.dp,50.dp,0.dp,0.dp).width(180.dp))
            IconButton(onClick = {  },
                modifier = Modifier
                    .padding(15.dp,50.dp,0.dp,0.dp).size(50.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(R.color.white))) {
                Icon(
                    painter = painterResource(id = R.drawable.bag),
                    contentDescription = "Корзина", modifier = Modifier.size(30.dp))
            }

        }
        val search = remember { mutableStateOf("") }
        Row( modifier = Modifier.padding(0.dp,30.dp)) {
            TextField(
modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp),
                value = search.value,
                textStyle = TextStyle(fontSize=14.sp),
                leadingIcon = { Icon(modifier = Modifier.padding(25.dp,0.dp,10.dp,0.dp).size(25.dp),painter = painterResource(id = R.drawable.search), contentDescription = "Проверено") },
                onValueChange = {newText -> search.value = newText},
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(R.color.white),
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = colorResource(R.color.white),
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = {Text("поиск")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(15.dp),

                )
            IconButton(onClick = {  },
                modifier = Modifier.size(50.dp) ,
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(R.color.accent))) {
                Icon(
                    painter = painterResource(id = R.drawable.sliders),
                    contentDescription = "Корзина", modifier = Modifier.size(30.dp), tint = Color.White)
            }
        }
        Text(text="Категории", modifier = Modifier.fillMaxWidth(1f).padding(30.dp, 0.dp,0.dp,10.dp), fontWeight = FontWeight.W400, textAlign=TextAlign.Left, fontSize = 20.sp)


    }

}

@Preview(locale = "es")
@Composable
fun PreviewMainPage() {
    MainPage(rememberNavController())
}