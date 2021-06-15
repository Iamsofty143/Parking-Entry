package com.example.parkingentry

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vehicle table")
data class Vehicle (
    @ColumnInfo(name = "vehicle_no") val vehicleNo: String?,
    @ColumnInfo(name = "vehicle_name") val vehicleName: String?
){
    @PrimaryKey(autoGenerate = true) var id=0
}