package com.example.bikes.data

class BicicletaRepository(private val bicicletaDao: BicicletaDao) {
    fun getAll() = bicicletaDao.getAll()
    fun getById(id: Int) = bicicletaDao.getById(id)
    fun insert(bicicleta: BicicletaEntity) = bicicletaDao.insert(bicicleta)
    fun update(bicicleta: BicicletaEntity) = bicicletaDao.update(bicicleta)
    fun delete(bicicleta: BicicletaEntity) = bicicletaDao.delete(bicicleta)
}


