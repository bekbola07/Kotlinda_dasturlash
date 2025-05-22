package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var flagImageView: ImageView
    private lateinit var descriptionText: TextView
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button

    private val images = arrayOf(
        R.drawable.kotlin,
        R.drawable.java,
        R.drawable.python
    )

    private val descriptions = arrayOf(
        "Kotlin — bu Java Virtual Mashinasida (JVM) ishlaydigan zamonaviy dasturlash tili bo‘lib, Android ilovalar yaratishda keng qo‘llaniladi. U soddaligi, xavfsiz sintaksisi va null pointer xatolarini kamaytirishi bilan mashhur. Kotlin Java bilan to‘liq mos keladi va undan qisqaroq kod yozishga imkon beradi.",
        "Java — bu platformadan mustaqil, obyektga yo‘naltirilgan dasturlash tili bo‘lib, ko‘plab tizimlarda (desktop, veb, mobil) qo‘llaniladi. Java o‘zining mustahkamlik, xavfsizlik va keng kutubxonalar ekotizimi bilan ajralib turadi. \"Write once, run anywhere\" (WORA) tamoyiliga asoslanadi.",
        "Python — bu yuqori darajadagi, oson o‘rganiladigan va soddaligi bilan mashhur dasturlash tili. U ilmiy hisoblash, sun’iy intellekt, veb-ishlab chiqish va avtomatlashtirishda keng qo‘llaniladi. Pythonning sintaksisi o‘quvchilarga tushunarli va lo‘nda."
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flagImageView = findViewById(R.id.flagImageView)
        descriptionText = findViewById(R.id.descriptionText)
        btnNext = findViewById(R.id.btnNext)
        btnBack = findViewById(R.id.btnBack)

        updateView()

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            updateView()
        }

        btnBack.setOnClickListener {
            currentIndex = (currentIndex - 1 + images.size) % images.size
            updateView()
        }
    }

    private fun updateView() {
        flagImageView.setImageResource(images[currentIndex])
        descriptionText.text = descriptions[currentIndex]
    }
}
