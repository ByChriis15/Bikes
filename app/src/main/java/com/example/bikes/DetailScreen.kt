package com.example.bikes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(bicicleta: NavHostController, text: String, text2: String, text3: String, text4: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Detalles de la Bicicleta",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            )
            Text(text = "Marca: ${bicicleta.marca}")
            Text(text = "Modelo: ${bicicleta.modelo}")
            Text(text = "Tipo: ${bicicleta.tipo}")
            Text(text = "Color: ${bicicleta.color}")
            Text(text = "Precio: ${bicicleta.precio}")
        }
    }
}
