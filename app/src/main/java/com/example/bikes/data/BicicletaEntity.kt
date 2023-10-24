package com.example.bikes.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class BicicletaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val marca: String,
    val modelo: String,
    val tipo: String, // Ejemplo: Montaña, Carretera, Urbana, etc.
    val color: String,
    val precio: Double
)

