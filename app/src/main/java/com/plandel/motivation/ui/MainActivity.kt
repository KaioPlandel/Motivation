package com.plandel.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Range
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.plandel.motivation.R
import com.plandel.motivation.infra.MotivationConstants
import com.plandel.motivation.infra.SecurityPreference
import com.plandel.motivation.repository.Mock
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var textName: TextView
    lateinit var securityPreference: SecurityPreference
    lateinit var buttonNewFrase: Button
    lateinit var textPhrase: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicialização
        textName = findViewById(R.id.textName)
        securityPreference = SecurityPreference(this)
        buttonNewFrase = findViewById(R.id.buttonNewFrase)
        textPhrase = findViewById(R.id.textPhrase)

        textPhrase.text =  Mock().getPhrase()

        val name = securityPreference.getString(MotivationConstants.KEY.PERSON_NAME)
        textName.text = "Olá $name!"


        buttonNewFrase.setOnClickListener {
            handleNewFrase()
        }


    }



    private fun handleNewFrase(){
        var phrases = Mock().getPhrase()
        textPhrase.text = phrases

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

}