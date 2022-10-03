package com.example.pizzadelivery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Confirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val bundle = getIntent().getExtras()
        if (bundle != null) {
            val name: String = intent.getStringExtra("Name").toString()
            var address = intent.getStringExtra("Address")
            val phone: String = intent.getStringExtra("Phone").toString()
            val email: String = intent.getStringExtra("Email").toString()
            var price = intent.getStringExtra("Price").toString()

            var nam = findViewById<TextView>(R.id.name);
            var add = findViewById<TextView>(R.id.address);
            var pho = findViewById<TextView>(R.id.phone);
            var ema = findViewById<TextView>(R.id.email);
            var pri = findViewById<TextView>(R.id.price);

            nam.text = name;
            add.text = address;
            pho.text = phone;
            ema.text = email;
            pri.text = price;

        }

        val submitBtn = findViewById(R.id.back) as Button
        submitBtn.setOnClickListener {
            val intent = Intent(this@Confirmation,MainActivity::class.java)
            startActivity(intent)

        }
    }
}