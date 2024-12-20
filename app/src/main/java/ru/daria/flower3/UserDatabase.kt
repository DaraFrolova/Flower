package ru.dara.flower3

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class UserDatabase(val context: Context, val factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, "Users", factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY, login TEXT,email TEXT, pass TEXT, tel TEXT, adr TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put("login",user.login)
        values.put("email",user.email)
        values.put("pass",user.pass)
        values.put("tel",user.tel)
        values.put("adr",user.adr)

        val db =this.writableDatabase
        db.insert("Users", null, values)

        db.close()
}




    @SuppressLint("Recycle")
    fun getUser(login: String, pass: String): Boolean{
        val db =this.readableDatabase

        val result = db.rawQuery("SELECT *FROM Users WHERE login = '$login' AND pass ='$pass'",null)
        return result.moveToFirst()
    }

    @SuppressLint("Recycle")
    fun getUser1(login: String): String{
        val db =this.readableDatabase
	var adr1 : String =" "
    val result = db.rawQuery("SELECT adr FROM Users WHERE login = '$login' ",null)
	if (result.moveToFirst()) {
        adr1 = result.getString(result.getColumnIndex("adr")) 
	 }
        return adr1
    }

    @SuppressLint("Recycle")
    fun getUser2(login: String): String{
        val db =this.readableDatabase
	var tel1 : String =" "
    val result = db.rawQuery("SELECT tel FROM Users WHERE login = '$login' ",null)
	if (result.moveToFirst()) {
        tel1 = result.getString(result.getColumnIndex("tel")) 
	 }
        return tel1
    }


    fun UpdateUser(login: String, adr1: String, tel1: String): Boolean{
        val db =this.readableDatabase

        val result = db.rawQuery("UPDATE Users SET adr= '$adr1' , tel= '$tel1'  WHERE login = '$login' ",null)
        return result.moveToFirst()
    }


}