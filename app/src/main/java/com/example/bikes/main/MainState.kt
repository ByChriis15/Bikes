package com.example.bikes.main


data class MainState(
    val marca: String = "",
    val modelo: String = "",
    val tipo: String = "", // Ejemplo: Montaña, Carretera, Urbana, etc.
    val color: String = "",
    val precio: Double = 0.0,
    val bicicletas: List<Bicicleta> = emptyList()
)

