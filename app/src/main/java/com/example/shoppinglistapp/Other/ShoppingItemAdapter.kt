package com.example.shoppinglistapp.Other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.Ui.ShoppingList.ShoppingViewModel
import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(var items : List<ShoppingItem>, private val viewmodel:
                          ShoppingViewModel): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
   inner class  ShoppingViewHolder(itemview:View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)

    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        val     currentShoppingItem= items[position]
        holder.itemView.tvname.text=currentShoppingItem.name
        holder.itemView.tvAmount.text = "${currentShoppingItem.amount}"
        holder.itemView.ivDelete.setOnClickListener{
            viewmodel.delete(currentShoppingItem)}
        holder.itemView.ivPlus.setOnClickListener{
            currentShoppingItem.amount++
            viewmodel.upsert(currentShoppingItem)
        }
        holder.itemView.ivMinus.setOnClickListener{
            if(currentShoppingItem.amount >0){
                currentShoppingItem.amount--
                viewmodel.upsert(currentShoppingItem)
            }

        }

    }

    override fun getItemCount(): Int {
return items.size

    }


}
