package com.example.shoppinglistapp.data.db.Enitities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName =  "shopping_Items" )
data class ShoppingItem  (
    @ColumnInfo (name ="itemName")
    var name :String,
    @ColumnInfo (name ="itemAmount")
    var amount : Int,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id  : Int?  =null

}