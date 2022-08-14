package com.example.shoppinglistapp.data.Ui.ShoppingList

import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.db.Enitities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog (context: Context, var dialogListner : DialogListner):AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        tvAdd.setOnClickListener{
            val  name = etName.text.toString()
            val amount = etAmount.text.toString()
            if(name.isEmpty()){
                Toast.makeText(context, "name empty ", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
            }
            val item =ShoppingItem(name,amount.toInt())
            dialogListner.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener{
            cancel()
        }
    }
}