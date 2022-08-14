package com.example.shoppinglistapp.data.Ui.ShoppingList

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistapp.data.Reopositories.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory (private val repository: ShoppingRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}

