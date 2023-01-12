package com.data.repository

import com.data.model.CarEntity
import com.data.port.CarRepositoryPort
import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import jakarta.inject.Singleton

@Singleton
class CarRepository(private val mongoClient: MongoClient) : CarRepositoryPort {
    override fun getAllCars(): List<CarEntity> {
        return getCollection().find().toList()
    }

    override fun getOneCar(id: String): CarEntity? {
        return getCollection().find(Filters.eq("_id", id)).firstOrNull()
    }

    override fun insertCar(carEntity: CarEntity): CarEntity {
        getCollection().insertOne(carEntity)
        return carEntity
    }

    override fun updateCar(carEntity: CarEntity): CarEntity {
        getCollection().replaceOne(Filters.eq("_id", carEntity.id), carEntity)
        return carEntity
    }

    override fun deleteCar(id: String): Boolean {
        val response = getCollection().deleteOne(Filters.eq("_id", id)).deletedCount.toInt()
        return response == 1
    }

    private fun getCollection() =
        mongoClient.getDatabase("data").getCollection("car", CarEntity::class.java)
}