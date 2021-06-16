package com.example.parkingentry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleRvAdapter(private val context: Context, private val listener: IVehicleRVAdapter ):
    RecyclerView.Adapter<VehicleRvAdapter.VehicleViewHolder>() {

    private val allVehicle = ArrayList<Vehicle>()



    inner class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById<TextView>(R.id.vehicleNo)
        val textView1: TextView = itemView.findViewById<TextView>(R.id.vehicleName)
        val deletBtn: ImageView = itemView.findViewById<ImageView>(R.id.btnDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val viewHolder = VehicleViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false))
        viewHolder.deletBtn.setOnClickListener{
            listener.onItemClicked(allVehicle[viewHolder.adapterPosition])
        }
        return  viewHolder
    }


    override fun getItemCount(): Int {
        return allVehicle.size
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val currentProduct = allVehicle[position]
        holder.textView.text = currentProduct.vehicleNo
        holder.textView1.text = currentProduct.vehicleName
    }

    fun updateProduct(newList: List<Vehicle>){
        allVehicle.clear()
        allVehicle.addAll(newList)

        notifyDataSetChanged()
    }

}


interface IVehicleRVAdapter{
    fun onItemClicked(vehicle: Vehicle)
}