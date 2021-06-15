package com.example.parkingentry

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: VehicleRepository
    val allVehicle: LiveData<List<Vehicle>>

    init {
        val dao  = VehicleDatabase.getDatabase(application).getVehicleDao()
        repository = VehicleRepository(dao)
        allVehicle = repository.allVehicle
    }

    fun deleteProduct (vehicle: Vehicle)= viewModelScope.launch(Dispatchers.IO){
        repository.delete(vehicle)
    }

    fun add(vehicle: Vehicle) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(vehicle)
    }
}