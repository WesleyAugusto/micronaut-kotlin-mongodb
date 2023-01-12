package com.data.controller

import com.data.model.CarEntity
import com.data.port.CarRepositoryPort
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import java.util.*

@Controller
class CarController(private val carRepositoryPort: CarRepositoryPort) {

    @Get
    fun getAllCars(): MutableHttpResponse<List<CarEntity>>? {
        return HttpResponse.ok(carRepositoryPort.getAllCars())
    }

    @Get("/{id}")
    fun getOneCar(@Parameter id: String): MutableHttpResponse<CarEntity?>? {
        return HttpResponse.ok(carRepositoryPort.getOneCar(id))

    }

    @Post
    fun insertCar(@Body carEntity: CarEntity): MutableHttpResponse<CarEntity>? {
        carEntity.id = UUID.randomUUID().toString()
        return HttpResponse.created(carRepositoryPort.insertCar(carEntity))
    }

    @Put
    fun updateCar(@Body carEntity: CarEntity): MutableHttpResponse<CarEntity>? {
        return HttpResponse.ok(carRepositoryPort.updateCar(carEntity))
    }

    @Delete("/{id}")
    fun deleteCar(@Parameter id: String): MutableHttpResponse<Boolean>? {
        return HttpResponse.ok(carRepositoryPort.deleteCar(id))
    }
}