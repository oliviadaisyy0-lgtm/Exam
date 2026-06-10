package com.example.exam


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainScreen : AppCompatActivity() {
    companion object{
        val itemArray = ArrayList <String>()
        val categoryArray = ArrayList <String>()
        val quantityArray = ArrayList <Int>()
        val commentsArray = ArrayList <String>()
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editItem = findViewById<EditText>(R.id.editItem)
        val editCategory = findViewById<EditText>(R.id.editCategory)
        val editQuantity = findViewById<EditText>(R.id.editQuantity)
        val editComments= findViewById<EditText>(R.id.editComments)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val buttonPack = findViewById<Button>(R.id.buttonPack)


        buttonPack.setOnClickListener {

            val item = editItem.text.toString()
            val category = editCategory.text.toString()
            val quantityText = editQuantity.text.toString()
            val comments = editComments.text.toString()

            // Error Handling
            if (item.isEmpty() || category.isEmpty() ||
                quantityText.isEmpty() || comments.isEmpty()) {

                Toast.makeText(this,
                    "Please fill in all ",
                    Toast.LENGTH_SHORT).show()

                Log.e("INPUT_ERROR", "Empty fields detected")

            } else {

                try {
                    val quantity = quantityText.toInt()

                    itemArray.add(item)
                    categoryArray.add(category)
                    quantityArray.add(quantity)
                    commentsArray.add(comments)

                    Toast.makeText(this,
                        "Total Items Packed",
                        Toast.LENGTH_SHORT).show()

                    Log.d("PACKING_APP", "Item Added: $item")

                    // Clear inputs
                    editItem.text.clear()
                    editCategory.text.clear()
                    editQuantity.text.clear()
                    editComments.text.clear()

                } catch (_: NumberFormatException) {

                    Toast.makeText(this,
                        "Quantity must be a number",
                        Toast.LENGTH_SHORT).show()

                    Log.e("INPUT_ERROR", "Invalid quantity")
                }
            }

        }
        buttonAdd.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }

        }
    }



