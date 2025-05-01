package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv1:TextView = findViewById(R.id.tv1)
        tv1.setOnClickListener{
            tv1.setBackgroundColor(Color.rgb(255,0,0))
        }
        val tv2:TextView = findViewById(R.id.tv2)
        tv2.setOnClickListener{
            tv2.setBackgroundColor(Color.rgb(0,0,0))
            tv2.setTextColor(Color.rgb(255,255,255))
        }

        val tv3:TextView = findViewById(R.id.tv3)
        tv3.setOnClickListener{
            tv3.setBackgroundColor(Color.rgb(0,255,0))
        }

        val tv4:TextView = findViewById(R.id.tv4)

        tv4.setOnClickListener{
            tv4.setBackgroundColor(Color.rgb(255,255,0))
        }

        val tv5:TextView = findViewById(R.id.tv5)
        tv5.setOnClickListener{
            tv5.setBackgroundColor(Color.rgb(0,0,255))
        }
    }
}