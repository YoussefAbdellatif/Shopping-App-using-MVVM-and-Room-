package com.example.shoppinglistapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert (item: ShoppingItem)



    @Query("SELECT * FROM SHOPPING_ITEMS")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>


    @Delete()
    suspend fun delete (item: ShoppingItem)
}