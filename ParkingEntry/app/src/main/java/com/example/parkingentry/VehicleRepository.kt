package com.example.parkingentry

import androidx.lifecycle.LiveData

class VehicleRepository (private val parkingDao: ParkingDao) {

    val allVehicle: LiveData<List<Vehicle>> = parkingDao.getAllVehicle()

    suspend fun insert (vehicle: Vehicle) {
        parkingDao.insert(vehicle)
    }

    suspend fun delete(vehicle: Vehicle){
        parkingDao.delete(vehicle)
    }
}