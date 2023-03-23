package com.offersonlineworld.uigandroid2project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Login : AppCompatActivity() {
    var auto : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auto = FirebaseAuth.getInstance()
        register_link.setOnClickListener {
            val i = Intent(this , Register :: class.java)
            startActivity(i)
        }
        login_button.setOnClickListener {
            val email = inputEmail_loging.text.toString()
            val password = inputPassword_login.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                auto!!.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                        val i = Intent(this , Home::class.java)
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

    }

    override fun onStart() {
        super.onStart()
        if (auto!!.currentUser != null) {
            val i = Intent(this , Home ::class.java)
            startActivity(i)
        }

    }
}