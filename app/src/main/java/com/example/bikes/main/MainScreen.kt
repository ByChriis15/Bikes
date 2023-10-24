package com.example.bikes.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavHostController) {
    val marca = remember { mutableStateOf("") }
    val modelo = remember { mutableStateOf("") }
    val color = remember { mutableStateOf("") }
    val tipo = remember { mutableStateOf("") }
    val precio = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(Color.Black.copy(alpha = 0.8f))
        ) {
            Text(text = "BikesTech", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White))
            Text(text = "Tejena Chavez Christopher", style = TextStyle(fontSize = 16.sp, color = Color.White))
            Text(text = "Septimo A", style = TextStyle(fontSize = 16.sp, color = Color.White))

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = marca.value,
                onValueChange = { marca.value = it },
                label = { Text("Marca") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = modelo.value,
                onValueChange = { modelo.value = it },
                label = { Text("Modelo") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = color.value,
                onValueChange = { color.value = it },
                label = { Text("Color") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tipo.value,
                onValueChange = { tipo.value = it },
                label = { Text("Tipo") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = precio.value,
                onValueChange = { newValue -> precio.value = newValue },
                label = { Text("Precio") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )


            Button(onClick = {
                // Lógica para guardar el registro
                viewModel.insert(Bicicleta(marca.value, modelo.value, tipo.value, color.value, precio.value.toDouble()))

            }) {
                Text("Guardar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                // Navegar a BicicletasScreen
            }) {
                Text("Ver registros")
            }
        }
    }
}
