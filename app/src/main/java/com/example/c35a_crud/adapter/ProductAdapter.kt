package com.example.c35a_crud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.c35a_crud.R
import com.example.c35a_crud.model.ProductModel
import java.util.ArrayList

class ProductAdapter(
    var context: Context,
    var data : ArrayList<ProductModel>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
   class ProductViewHolder(itemView: View)
       : RecyclerView.ViewHolder(itemView){
       val pName : TextView = itemView.findViewById(R.id.displayName)
       val pPrice : TextView = itemView.findViewById(R.id.displayPrice)
       val pDesc : TextView = itemView.findViewById(R.id.displayDesc)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val itemView : View = LayoutInflater.from(context)
            .inflate(R.layout.sample_products,parent,false)

        return ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.pName.text = data[position].productName
        holder.pPrice.text = data[position].price.toString()
        holder.pDesc.text = data[position].productDesc
    }

    fun updateData(products : List<ProductModel>){
        data.clear()
        data.addAll(products)
        notifyDataSetChanged()
    }
}