package com.example.cafeexpress

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var btnAddCofe: Button
    private lateinit var btnRemoveCofe: Button
    private lateinit var countCofe: TextView
    private lateinit var btnAddEspresso: Button
    private lateinit var btnRemoveEspresso: Button
    private lateinit var countEspresso:TextView
    private lateinit var btnAddCroissant: Button
    private lateinit var btnRemoveCroissant: Button
    private lateinit var countCroissant: TextView
    private lateinit var etext: EditText
    private lateinit var total: TextView
    private lateinit var vide: Button
    private lateinit var commnde: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAddCofe = findViewById(R.id.btnAddCafe)
        btnRemoveCofe = findViewById(R.id.btnRemoveCafe)
        countCofe = findViewById(R.id.countCofe)
        btnAddEspresso= findViewById(R.id.btnAddEspresso)
        btnRemoveEspresso= findViewById(R.id.btnRemoveEspresso)
        countEspresso = findViewById(R.id.countEspresso)
        btnAddCroissant= findViewById(R.id.btnAddCroissant)
        btnRemoveCroissant = findViewById(R.id.btnRemoveCroissant)
        countCroissant = findViewById(R.id.countCroissant)
        etext= findViewById(R.id.etext)
        total= findViewById(R.id.total)
        vide= findViewById(R.id.vide)
        commnde= findViewById(R.id.commnde)

        var counterCofe = 0
        var counterEspresso = 0
        var counterCroissant = 0
        var max = 0
        var article = 0

        btnRemoveCofe.setOnClickListener {
            counterCofe += 1
            max += 10
            article +=1
            countCofe.text = counterCofe.toString()
            total.text = max.toString()
        }

        btnRemoveEspresso.setOnClickListener {
            counterEspresso += 1
            max +=  8
            article +=1
            countEspresso.text = counterEspresso.toString()
            total.text = max.toString()
        }

        btnRemoveCroissant.setOnClickListener {
            counterCroissant += 1
            max += 6
            article +=1
            countCroissant.text = counterCroissant.toString()
            total.text = max.toString()
        }
        btnAddCofe.setOnClickListener {
            if(counterCofe>0){
            counterCofe -= 1
                max -= 10
                article -=1
                total.text = max.toString()
            countCofe.text = counterCofe.toString()}

        }

        btnAddEspresso.setOnClickListener {
            if(counterEspresso>0){
            counterEspresso -= 1
                max -= 8
                article -=1
                total.text = max.toString()
            countEspresso.text = counterEspresso.toString()}

        }

        btnAddCroissant.setOnClickListener{
            if(counterCroissant>0){
            counterCroissant -= 1
                max -= 6
                article -=1
                total.text = max.toString()
            countCroissant.text = counterCroissant.toString()}  }

            commnde.setOnClickListener {
                if (etext.text.toString().isEmpty()) {
                    Toast.makeText(this, "Veuillez entrer votre nom", Toast.LENGTH_SHORT).show()
                } else if (counterCofe == 0 && counterEspresso == 0 && counterCroissant == 0 ){
                    Toast.makeText(this, "Veuillez commander", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "merci ${etext.text.trim().toString()} : ${article} articles, ${max} DH", Toast.LENGTH_SHORT).show()
                }
                }
        vide.setOnClickListener {
            counterCofe = 0
            counterEspresso = 0
            counterCroissant = 0
            max = 0
            article = 0
            countCofe.text = counterCofe.toString()
            countEspresso.text = counterEspresso.toString()
            countCroissant.text = counterCroissant.toString()
            total.text = max.toString()
            Toast.makeText(this, "commende annulée", Toast.LENGTH_SHORT).show()
        }






        }
        }


