package com.example.parkingentry

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ParkingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicle: Vehicle)

    @Delete
    suspend fun delete(vehicle: Vehicle)

    @Query("Select * from `vehicle table` order by id ASC")
    fun getAllVehicle(): LiveData<List<Vehicle>>
}