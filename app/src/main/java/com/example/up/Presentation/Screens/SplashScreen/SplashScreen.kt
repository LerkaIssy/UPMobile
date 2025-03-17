package com.example.up.Presentation.Screens.SplashScreen

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.up.R
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember {
        Animatable(0.5f)
    } //объект, используемый для управления масштабированием логотипа

    //Запускает асинхронный блок кода, который выполняется один раз при композиции
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 2f,
            animationSpec = tween(
                durationMillis = 1500,
                easing = {
                    OvershootInterpolator(0.5f).getInterpolation(it)
                })
        )// Анимирует изменение значения scale от 0.5f до 2f в течение 1500 миллисекунд, используя OvershootInterpolator для эффекта перескока

        delay(1500L) //Пауза на 1.5 секунды после завершения анимации

        //После паузы, переходит на экран входа в систему (SIGNIN), удаляя экран заставки из стека навигации
        // navController.navigate(NavigationRoutes.SIGNIN) {
        //   popUpTo(NavigationRoutes.SPLASH) {
        //     inclusive = true
        //}
    }


    //Получает размеры экрана
    BoxWithConstraints {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.logo),
                contentDescription = "Зимний лес",
                modifier = Modifier.scale(scale.value)
            )
        }
    }
}