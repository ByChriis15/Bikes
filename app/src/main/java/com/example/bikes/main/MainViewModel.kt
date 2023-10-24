package com.example.bikes.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bikes.data.BicicletaEntity
import com.example.bikes.data.BicicletaRepository
import kotlinx.coroutines.launch


class MainViewModel(private val repository: BicicletaRepository) : ViewModel() {
    val bicicletas = repository.getAll()

    fun insert(bicicleta: Bicicleta) = viewModelScope.launch {
        val bicicletaEntity = BicicletaEntity(

            //id = bicicleta.id,
            marca = bicicleta.marca,
            modelo = bicicleta.modelo,
            color = bicicleta.color,
            tipo = bicicleta.tipo,
            precio = bicicleta.precio
        )
        repository.insert(bicicletaEntity)
    }


    fun update(bicicleta: BicicletaEntity) = viewModelScope.launch {
        repository.update(bicicleta)
    }

    fun delete(bicicleta: BicicletaEntity) = viewModelScope.launch {
        repository.delete(bicicleta)
    }

    fun obtenerBicicletas(): List<Bicicleta> {
        TODO("Not yet implemented")
    }
}
