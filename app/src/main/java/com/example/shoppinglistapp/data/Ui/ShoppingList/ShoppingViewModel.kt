package com.example.shoppinglistapp.data.Ui.ShoppingList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.data.Reopositories.ShoppingRepository
import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() { CoroutineScope(Dispatchers.Main).launch {
        repository.getAllShoppingItems() as LiveData<List<ShoppingItem>>

    }
    }
    }
