package com.example.primeiroapppb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeiroapppb.databinding.ActivityLoginBinding
import com.example.primeiroapppb.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

// ... (suas importações existentes)

    class loginActivity : AppCompatActivity() {

        private lateinit var binding: ActivityLoginBinding // Declare a propriedade binding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityLoginBinding.inflate(layoutInflater)
            // Inicialize o binding aqui

            enableEdgeToEdge() // Certifique-se de que enableEdgeToEdge() não depende do binding
            setContentView(binding.root)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets

            }

            // Agora você pode acessar elementos da interface do usuário através do binding
            binding.Conectar.setOnClickListener {
                val emailEditText = binding.editTextText
                val passwordEditText = binding.editTextTextPassword

                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (email == "admin@admin.com" && password == "admin") {
                    // Credenciais corretas, navegue para a tela de Integrantes
                    val intent = Intent(this, teste::class.java)
                    startActivity(intent)
                } else {
                    // Credenciais incorretas, exiba uma mensagem de erro
                    Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

