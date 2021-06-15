package com.example.parkingentry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: VehicleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(VehicleViewModel::class.java)
        viewModel.allVehicle.observe(this, Observer { list ->
            list?.let {

            }

        })
    }

    fun Park(view: View) {
        val vehicleNo = number.text.toString()
        val vehicleName = name.text.toString()
        if(vehicleName.isNotEmpty() && vehicleNo.isNotEmpty() ){
            viewModel.add(Vehicle(vehicleNo,vehicleName))
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
            number.text.clear()
            name.text.clear()

            val recordActivityIntent = Intent(this, RecordActivty::class.java)
            startActivity(recordActivityIntent)
        }
    }

    fun openRecord(view: View) {
        val recordActivityIntent = Intent(this, RecordActivty::class.java)
        startActivity(recordActivityIntent)
    }
}