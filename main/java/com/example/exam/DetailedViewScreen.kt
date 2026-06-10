package com.example.exam


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val buttonDisplay = findViewById<Button>(R.id.buttonDisplay)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val buttQuantity = findViewById<Button>(R.id.buttonQuantity)
        val textOut = findViewById<TextView>(R.id.textOut)

        buttonDisplay.setOnClickListener {

            var output = ""

            for (i in MainScreen.itemArray.indices) {

                output += """
            Item: ${MainScreen.itemArray[i]}
            Category: ${MainScreen.categoryArray[i]}
            Quantity: ${MainScreen.quantityArray[i]}
            Comments: ${MainScreen.commentsArray[i]}
            
            """.trimIndent()

                output += "\n\n"
            }

            textOut.text = output

            Log.d("PACKING_APP", "Displayed full packing list")
        }
        buttQuantity.setOnClickListener {
            var output = ""

            for (i in MainScreen.quantityArray.indices) {

                if (MainScreen.quantityArray[i] >= 2) {

                    output +=
                        "${MainScreen.itemArray[i]} " +
                                "- Quantity: ${MainScreen.quantityArray[i]}\n"
                }
            }


            buttonBack.setOnClickListener { buttonBack.text = "Back to base" }

            buttonBack.setOnClickListener {
                finish()
            }
        }
    }
}








