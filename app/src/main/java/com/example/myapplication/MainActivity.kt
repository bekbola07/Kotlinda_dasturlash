package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var btnSave: Button
    private lateinit var tvStudents: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        btnSave = findViewById(R.id.btnSave)
        tvStudents = findViewById(R.id.tvStudents)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val ageText = etAge.text.toString()

            if (name.isNotEmpty() && ageText.isNotEmpty()) {
                val age = ageText.toIntOrNull()
                if (age != null) {
                    val success = dbHelper.insertStudent(name, age)
                    if (success) {
                        Toast.makeText(this, "Ma'lumot saqlandi", Toast.LENGTH_SHORT).show()
                        etName.text.clear()
                        etAge.text.clear()
                        showAllStudents()
                    } else {
                        Toast.makeText(this, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Yosh son bo‘lishi kerak", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Iltimos, barcha maydonlarni to‘ldiring", Toast.LENGTH_SHORT).show()
            }
        }

        showAllStudents()
    }

    private fun showAllStudents() {
        val studentList = dbHelper.getAllStudents()
        tvStudents.text = if (studentList.isNotEmpty()) {
            studentList.joinToString("\n")
        } else {
            "Hozircha ma'lumot yo‘q"
        }
    }
}

