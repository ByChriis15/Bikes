package com.example.bikes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface BicicletaDao {
    @Query("SELECT * FROM BicicletaEntity")
    fun getAll(): List<BicicletaEntity>

    @Query("SELECT * FROM BicicletaEntity WHERE id = :id")
    fun getById(id: Int): BicicletaEntity

    @Insert
    fun insert(bicicleta: BicicletaEntity)

    @Update
    fun update(bicicleta: BicicletaEntity)

    @Delete
    fun delete(bicicleta: BicicletaEntity)
}
