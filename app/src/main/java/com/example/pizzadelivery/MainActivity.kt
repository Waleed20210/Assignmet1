package com.example.pizzadelivery

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.pizzadelivery.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var list_of_items = arrayOf("Select Topping", "Mushroom(\$5)",
        "Sun Dried Tomatoes(\$5)", "Chicken(\$7)", "Ground Beef(\$8)", "Shrimps(\$10)"
        , "Pineapple(\$5)", "Steak(\$9)", "Avocado(\$5)", "Tuna(\$5)"
        , "Broccoli \$8")
    var topping = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, list_of_items)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    topping = position;
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

            val submitBtn = findViewById(R.id.submit) as Button
            submitBtn.setOnClickListener {
                val intent = Intent(this@MainActivity,Confirmation::class.java)

                var price = 0.0;
                val name = findViewById<EditText>(R.id.name).text;
                val email = findViewById<EditText>(R.id.email).text;
                val address = findViewById<EditText>(R.id.address).text;
                val phone = findViewById<EditText>(R.id.phone).text;

                val sixSlice = findViewById<RadioButton>(R.id.sixSlice)
                val eightSlice = findViewById<RadioButton>(R.id.eightSlice)
                val tenSlice = findViewById<RadioButton>(R.id.tenSlice)
                val twelveSlice = findViewById<RadioButton>(R.id.twelveSlice)

                val cheese = findViewById<CheckBox>(R.id.cheese);
                val delivery = findViewById<CheckBox>(R.id.delivery);

                if(sixSlice.isChecked())
                {
                    price += 5.50;
                }
                else if(eightSlice.isChecked())
                {
                    price += 7.99;
                }
                else if(tenSlice.isChecked())
                {
                    price += 9.50;
                }
                else if(twelveSlice.isChecked())
                {
                    price += 11.38;
                }

                if(topping == 1)
                {
                    price += 5;
                }
                else if(topping == 2)
                {
                    price += 5;
                }
                else if(topping == 3)
                {
                    price += 7;
                }
                else if(topping == 4)
                {
                    price += 8;
                }
                else if(topping == 5)
                {
                    price += 10;
                }
                else if(topping == 6)
                {
                    price += 5;
                }
                else if(topping == 7)
                {
                    price += 9;
                }
                else if(topping == 8)
                {
                    price += 5;
                }
                else if(topping == 9)
                {
                    price += 5;
                }
                else if(topping == 10)
                {
                    price += 8;
                }

                if(cheese.isChecked())
                {
                    price += 5;
                }

                if(delivery.isChecked())
                {
                    price += 5;
                }

                val mybundle = Bundle()
                mybundle.putString("Name", name.toString())
                mybundle.putString("Email", email.toString())
                mybundle.putString("Address", address.toString())
                mybundle.putString("Phone", phone.toString())
                mybundle.putString("Price", price.toString())

                intent.putExtras(mybundle);

                startActivity(intent)

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}