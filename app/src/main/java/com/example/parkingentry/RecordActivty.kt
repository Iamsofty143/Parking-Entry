package com.example.parkingentry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_record_activty.*

class RecordActivty : AppCompatActivity(), IVehicleRVAdapter {
    lateinit var viewModel: VehicleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_activty)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = VehicleRvAdapter(this,this)
        recyclerView.adapter = adapter

        viewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(VehicleViewModel::class.java)
        viewModel.allVehicle.observe(this, Observer { list ->
            list?.let {
                adapter.updateProduct(it)
            }

        })

    }
    override fun onItemClicked(vehicle: Vehicle) {
        viewModel.deleteProduct(vehicle)
        Toast.makeText(this, "Vehicle Removed From Parking", Toast.LENGTH_LONG).show()
    }
}