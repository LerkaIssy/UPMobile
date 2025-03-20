package com.example.up.Presentation.Screens.SignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.up.Presentation.Screens.SignIn.SignIn
import com.example.up.R

@Composable
fun SignUp(navHost: NavHostController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    var passwordVisibility by remember { mutableStateOf(false) }
    var approve by remember { mutableStateOf(false) }
    Row(){
        IconButton(onClick = { navHost.navigate("SignIn") },
            modifier = Modifier
                .padding(15.dp,50.dp).size(50.dp),
            colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(R.color.veryLight))) {
            Icon(
                Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Назад", modifier = Modifier.size(80.dp),
                tint = Color.DarkGray)
        }

    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .imePadding()
            .fillMaxWidth(1f)
    ) {
        Text(text="Регистрация", fontWeight = FontWeight.W400, fontSize = 32.sp)
        Spacer(Modifier.height(8.dp))
        Text(text="Заполните Свои Данные", fontWeight = FontWeight.W100, fontSize = 24.sp)
        Spacer(Modifier.height(30.dp))
        Text(text="Ваше имя", modifier = Modifier.fillMaxWidth(1f).padding(10.dp, 0.dp,0.dp,10.dp), fontWeight = FontWeight.W400, textAlign= TextAlign.Left, fontSize = 20.sp)

        TextField(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            value = name.value,
            textStyle = TextStyle(fontSize=14.sp),

            onValueChange = {newText -> name.value = newText},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.veryLight),
                unfocusedTextColor = Color.Black,
                focusedContainerColor = colorResource(R.color.veryLight),
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            shape = RoundedCornerShape(15.dp),

            )
        Spacer(Modifier.height(20.dp))
        Text(text="Email", modifier = Modifier.fillMaxWidth(1f).padding(10.dp, 0.dp,0.dp,10.dp), fontWeight = FontWeight.W400, textAlign= TextAlign.Left, fontSize = 20.sp)

        TextField(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            value = email.value,
            textStyle = TextStyle(fontSize=14.sp),

            onValueChange = {newText -> email.value = newText},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.veryLight),
                unfocusedTextColor = Color.Black,
                focusedContainerColor = colorResource(R.color.veryLight),
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            shape = RoundedCornerShape(15.dp),

            )
        Spacer(Modifier.height(20.dp))
        Text(text="Пароль", modifier = Modifier.fillMaxWidth(1f).padding(10.dp, 0.dp,0.dp,10.dp), fontWeight = FontWeight.W400, textAlign= TextAlign.Left, fontSize = 20.sp)

        TextField(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            value = password.value,
            textStyle = TextStyle(fontSize=14.sp),
            onValueChange = {newText -> password.value = newText},
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    if (passwordVisibility) {
                        Icon(
                            painter = painterResource(id = R.drawable.eyeopen),
                            contentDescription = ""
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.eyeclose),
                            contentDescription = ""
                        )
                    }
                }
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.veryLight),
                unfocusedTextColor = Color.Black,
                focusedContainerColor = colorResource(R.color.veryLight),
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            shape = RoundedCornerShape(15.dp),

            )
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

            IconButton(
                onClick = { approve = !approve },

                colors = IconButtonDefaults.iconButtonColors(containerColor = if(approve) colorResource(R.color.accent) else colorResource(R.color.veryLight))
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = "Назад", modifier = Modifier.size(20.dp),
                    tint = Color.DarkGray
                )
            }
            Text(
                text = "Даю согласие на обработку персональных данных",
                modifier = Modifier.fillMaxWidth(1f).padding(7.dp, 0.dp, 20.dp, 0.dp),
                fontWeight = FontWeight.W200,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Left,
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.height(15.dp))
        Button(onClick = {},
            shape = RoundedCornerShape(15.dp),  // округлая кнопка
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            contentPadding = PaddingValues(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.accent)
            )
        ){ Text("Зарегистрироваться", fontSize = 17.sp) }
        //Spacer(Modifier.height(80.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Есть аккаунт?", fontSize = 16.sp, fontWeight = FontWeight.W200)
            TextButton(onClick = {navHost.navigate("SignIn")}) {
                Text("Войти", fontSize = 16.sp, color = Color.Black)
            }
        }

    }
}
@Preview(locale = "es")
@Composable
fun PreviewSigUp() {
    SignUp(rememberNavController())
}