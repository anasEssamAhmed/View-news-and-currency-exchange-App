package com.offersonlineworld.uigandroid2project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    var auto: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auto = FirebaseAuth.getInstance()
        registerButton.setOnClickListener {
            val email = inputEmail_register.text.toString()
            val password = inputPassword_register.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auto!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                        val i = Intent(this , Login::class.java)
                        startActivity(i)
                        finishAffinity()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }else {
                Toast.makeText(this , "The input is empty" , Toast.LENGTH_SHORT).show()
            }
        }
        login_link.setOnClickListener {
            val i = Intent(this , Login :: class.java)
            startActivity(i)
        }
    }
}