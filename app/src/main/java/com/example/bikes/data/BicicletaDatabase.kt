package com.example.bikes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BicicletaEntity::class], version = 1)
abstract class BicicletaDatabase : RoomDatabase() {
    abstract val dao: BicicletaDao

    abstract fun bicicletaDao(): BicicletaDao
}

