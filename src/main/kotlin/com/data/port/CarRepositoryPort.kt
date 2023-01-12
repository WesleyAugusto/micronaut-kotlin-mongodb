package com.data.port

import com.data.model.CarEntity

interface CarRepositoryPort {
    fun getAllCars(): List<CarEntity>
    fun getOneCar(id: String): CarEntity?
    fun insertCar(carEntity: CarEntity): CarEntity
    fun updateCar(carEntity: CarEntity): CarEntity
    fun deleteCar(id: String): Boolean
}