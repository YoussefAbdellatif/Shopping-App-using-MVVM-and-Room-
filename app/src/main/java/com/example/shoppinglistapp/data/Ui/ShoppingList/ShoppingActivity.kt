package com.example.shoppinglistapp.data.Ui.ShoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.Other.ShoppingItemAdapter
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.Reopositories.ShoppingRepository
import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem
import com.example.shoppinglistapp.data.db.ShoppingDatabase
import kotlinx.android.synthetic.main.activity_shopping.*


class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val  database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
    val factory = ShoppingViewModelFactory(repository)

    val viewmodel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)
        val adapter = ShoppingItemAdapter(listOf(),viewmodel)
    rvShoppinItems.layoutManager = LinearLayoutManager(this)
        rvShoppinItems.adapter = adapter

       (viewmodel.getAllShoppingItems() as LiveData<List<ShoppingItem>>).observe(this, Observer{
           adapter.items = it
           adapter.notifyDataSetChanged()
       })



        fab.setOnClickListener{
            AddShoppingItemDialog(this, object :DialogListner{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewmodel.upsert(item)
                }
            }).show()

        }
    }

}