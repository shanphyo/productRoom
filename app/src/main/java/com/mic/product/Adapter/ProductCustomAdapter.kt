package com.mic.product.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mic.product.Database.Entity.Product
import com.mic.product.R
import kotlinx.android.synthetic.main.itemproduct.view.*

class ProductCustomAdapter (var plist:List<Product>):RecyclerView.Adapter<ProductCustomAdapter.pViewHolder>(){
    inner  class pViewHolder(itemvew: View):RecyclerView.ViewHolder(itemvew){

        fun bindProduct(product:Product){
            itemView.txt_name.text=product.pname
            itemView.txt_quantity.text=product.pquantity
            itemView.txt_price.text=product.pprice.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pViewHolder {
        var view= LayoutInflater.from(parent.context)
            .inflate(R.layout.itemproduct,parent,false)
        return pViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("Size=>>>>","${plist.size}")
        return plist.size
    }

    override fun onBindViewHolder(holder: pViewHolder, position: Int) {
        holder.bindProduct(plist[position])
    }
    fun updateList(prlist:List<Product>){
        plist=prlist
        notifyDataSetChanged()
    }
}