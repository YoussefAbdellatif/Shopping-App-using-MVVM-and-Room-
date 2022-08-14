package com.example.shoppinglistapp.data.Ui.ShoppingList

import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem

interface DialogListner {
    fun onAddButtonClicked (item:ShoppingItem)
}