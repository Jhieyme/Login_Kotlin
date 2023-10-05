package com.jennifer.login_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jennifer.login_kotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    /*lateinit var username : EditText
    lateinit var password : EditText
    lateinit var loginButton: Button*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(View.OnClickListener {
            if (binding.username.text.toString() == "admin" && binding.password.text.toString() == "1234"){
                //Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
            }else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}