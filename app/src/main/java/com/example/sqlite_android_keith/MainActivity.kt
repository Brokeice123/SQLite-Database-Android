package com.example.sqlite_android_keith

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var dbName:EditText
    lateinit var dbEmail:EditText
    lateinit var dbID:EditText
    lateinit var dbSave:Button
    lateinit var dbView:Button
    lateinit var dbDelete:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbName = findViewById(R.id.edtName)
        dbEmail = findViewById(R.id.edtEmail)
        dbID = findViewById(R.id.edtID)
        dbSave = findViewById(R.id.btnSave)
        dbView = findViewById(R.id.btnView)
        dbDelete = findViewById(R.id.btnDelete)

        //Creating a Database
        db = openOrCreateDatabase("KeithDatabase", Context.MODE_PRIVATE, null)

        //Creating a Table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")

        dbSave.setOnClickListener {
            var jina_edt = dbName.text.toString().trim()
            var arafa_edt = dbEmail.text.toString().trim()
            var kitambulisho_edt = dbID.text.toString().trim()

            //Validation of edit Texts
            if (jina_edt.isEmpty() || arafa_edt.isEmpty() || kitambulisho_edt.isEmpty()){
                Toast.makeText(this, "Cannot Submit an Empty Field", Toast.LENGTH_SHORT).show()
            }
            else{
                //Insert Data
                db.execSQL("INSERT INTO users VALUES('\"+jina_edt+\"' , '\"+arafa_edt+\"' , '\"+kitambulisho_edt+\"')")
                Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            }

        }


    }
}