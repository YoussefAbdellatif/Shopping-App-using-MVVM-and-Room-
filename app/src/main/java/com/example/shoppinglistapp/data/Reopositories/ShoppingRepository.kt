package com.example.shoppinglistapp.data.Reopositories

import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem
import com.example.shoppinglistapp.data.db.ShoppingDatabase

class ShoppingRepository (private val db :  ShoppingDatabase){
suspend fun upsert (item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun  delete(item: ShoppingItem) = db.getShoppingDao().delete(item)
    suspend fun  getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()


}