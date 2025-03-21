package com.example.up.Presentation.Screens.Catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.up.Presentation.Screens.MainPage.MainPage
import com.example.up.Presentation.Screens.MainPage.MainPageVM
import com.example.up.Presentation.Screens.MainPage.id
import com.example.up.R


@Composable
fun Catalog(navHost: NavHostController, CatalogVM: CatalogVM = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(1f).background(colorResource(R.color.background)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(1f), horizontalArrangement = Arrangement.Start) {
            IconButton(
                onClick = { navHost.navigate("MainPage") },
                modifier = Modifier
                    .padding(15.dp,50.dp,0.dp, 0.dp).size(50.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(R.color.white))
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Назад", modifier = Modifier.size(80.dp),
                    tint = Color.DarkGray
                )
            }
        }
        CatalogVM.CategoryList()
        Text(
            text = "Категории",
            modifier = Modifier.fillMaxWidth(1f).padding(30.dp, 20.dp, 0.dp, 10.dp),
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Left,
            fontSize = 20.sp
        )
        Row {
            Button(
                {id="все"},
                modifier = Modifier.padding(20.dp, 8.dp).size(110.dp, 45.dp),
                shape = RoundedCornerShape(15.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.white)
                )
            ) {
                Text("Все", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.W200)
            }
            LazyRow(modifier = Modifier.fillMaxWidth(1f)) {

                items(CatalogVM.categories, key = { categories -> categories.id },)
                {

                        categories ->
                    Button(
                        {id=categories.id},
                        modifier = Modifier.padding(20.dp, 8.dp).size(110.dp, 45.dp),
                        shape = RoundedCornerShape(15.dp),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.white)
                        )
                    ) {
                        Text(
                            categories.title,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W200
                        )
                    }
                }
            }
        }
        CatalogVM.ProductsList()
        LazyColumn(modifier = Modifier.fillMaxWidth(1f).padding(30.dp,0.dp), ) {

            items(CatalogVM.products, key = { products -> products.id },)
            {

                    products ->

                if (products.category_id.contains(id)) {
                    val imageState = rememberAsyncImagePainter(
                        model = coil.request.ImageRequest.Builder(LocalContext.current)
                            .data(products.image)
                            .size(coil.size.Size.ORIGINAL).build()
                    ).state
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(180.dp, 250.dp),
                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)).padding(10.dp)
                        ) {
                            if (imageState is AsyncImagePainter.State.Error) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp).width(180.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }

                            if (imageState is AsyncImagePainter.State.Success) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    painter = imageState.painter,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            if (products.is_best_seller){
                                Text(
                                    "BEST SELLER", color = colorResource(R.color.accent)
                                )
                            }

                            Text(
                                products.title,
                            )
                            Text(
                                products.cost.toString(),
                            )

                        }}
                }
                if(id.contains("все"))
                {
                    val imageState = rememberAsyncImagePainter(
                        model = coil.request.ImageRequest.Builder(LocalContext.current)
                            .data(products.image)
                            .size(coil.size.Size.ORIGINAL).build()
                    ).state
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(180.dp, 250.dp),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)).padding(10.dp)
                        ) {
                            if (imageState is AsyncImagePainter.State.Error) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp).width(180.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }

                            if (imageState is AsyncImagePainter.State.Success) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    painter = imageState.painter,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            if (products.is_best_seller){
                                Text(
                                    "BEST SELLER", color = colorResource(R.color.accent)
                                )
                            }

                            Text(
                                products.title,
                            )
                            Text(
                                products.cost.toString(),
                            )

                        }}
            }
        }
    }
    }
}


@Preview(locale = "es")
@Composable
fun PreviewCatalog() {
    Catalog(rememberNavController())
}