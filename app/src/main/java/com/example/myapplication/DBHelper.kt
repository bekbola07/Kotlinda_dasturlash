package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "Mydb", null, 1) {

    companion object {
        const val TABLE_NAME = "Student"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_AGE = "age"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME TEXT," +
                "$COL_AGE INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertStudent(name: String, age: Int): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_NAME, name)
        values.put(COL_AGE, age)
        val result = db.insert(TABLE_NAME, null, values)
        return result != -1L
    }
    fun getAllStudents(): List<String> {
        val studentList = mutableListOf<String>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME))
                val age = cursor.getInt(cursor.getColumnIndexOrThrow(COL_AGE))
                studentList.add("Ism: $name, Yosh: $age")
            } while (cursor.moveToNext())
        }

        cursor.close()
        return studentList
    }

}
