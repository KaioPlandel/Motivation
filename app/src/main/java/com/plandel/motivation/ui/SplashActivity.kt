package com.plandel.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.plandel.motivation.R
import com.plandel.motivation.infra.MotivationConstants

import com.plandel.motivation.infra.SecurityPreference


class SplashActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var editName: EditText
    lateinit var securityPreference: SecurityPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        button = findViewById(R.id.buttonsave)
        editName = findViewById(R.id.editName)
        securityPreference = SecurityPreference(this)

        button.setOnClickListener { handleSave() }

        updateName()

//      val shared =  this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
//        shared.edit().putString("nome","value").apply()


    }

    private fun updateName(){
        var name = securityPreference.getString(MotivationConstants.KEY.PERSON_NAME)
        if(name.isNotEmpty()){
            Intent(this, MainActivity::class.java).also {

                startActivity(it)
            }
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()
        if (name.isEmpty()) {
            Toast.makeText(this,"Digite o nome",Toast.LENGTH_SHORT).show()
        }else {
            securityPreference.storeString(MotivationConstants.KEY.PERSON_NAME,name)
            Intent(this, MainActivity::class.java).also {

                startActivity(it)
            }
        }
    }
}