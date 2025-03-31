package vcmsa.ci.mealplan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var timeOfday: EditText? = null
    private var suggestMeal: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Initialises the view

        timeOfday = findViewById(R.id.timeOfDay)
        suggestMeal = findViewById(R.id.suggestMeal)

        val btnSug = findViewById<Button>(R.id.btnSug)
        val btnClr = findViewById<Button>(R.id.btnClr)
        val btnExt = findViewById<Button>(R.id.btnExt)


        // Manages the "Choose meal" button click, which suggests meals according to the timeOfDay inputted

        btnSug.setOnClickListener {
            if (isNotEmpty()) {
                val time = timeOfday?.text.toString().trim()
                chooseMeal(time)
            }
        }

        // Controls "Clear" button click, which clears the Edit text

        btnClr.setOnClickListener {
            timeOfday?.text?.clear()
            suggestMeal?.text = ""
        }

        // Deals with "Exit" button click, which exits the app

        btnExt.setOnClickListener {
            moveTaskToBack(true)
            finish()
        }
    }

    // Function to check if timeOfDay is empty

    private fun isNotEmpty(): Boolean {
        return if (timeOfday?.text.toString().trim().isEmpty()) {
            timeOfday?.error = "Please enter the time of day eg.(Morning)"
            false
        } else {
            true
        }
    }

    // Function to suggest a meal based on the time of day

    private fun chooseMeal(time: String) {
        val suggestion = when (time.lowercase(Locale.ROOT)) {
            "morning" -> "Breakfast: Pancakes with syrup and bacon, Scrambled Eggs on toast, and Coffee"
            "mid-morning snack" -> "Light snack: Fruit Salad, Smoothie, and Protein  Bar"
            "afternoon" -> " Lunch: Burger with fries, Sandwich, and Juice"
            "afternoon snack" -> "Quick bites: Mini rice cake, Dried fruit mix, and Chocolate"
            "dinner" -> "Main course: Grilled Chicken with Pap, lasagna with Garlic Bread, and Beef Stew with Rice"
            "after dinner" -> "Dessert: Jelly and Custard, Ice cream, and Cheesecake"
            else -> "Invalid time of day. Please enter Morning, Mid-morning snack, Afternoon, Afternoon snack, Dinner, After dinner"

        }
        suggestMeal?.text = suggestion
    }
}




