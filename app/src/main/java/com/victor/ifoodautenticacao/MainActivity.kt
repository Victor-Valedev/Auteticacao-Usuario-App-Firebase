package com.victor.ifoodautenticacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.victor.ifoodautenticacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val autenticacao = FirebaseAuth.getInstance()


       binding.btnCadastro.setOnClickListener {
           val email = binding.editEmail.text.toString()
           val senha = binding.editSenha.text.toString()
           autenticacao.createUserWithEmailAndPassword(
               email, senha
           ).addOnSuccessListener {
               Toast.makeText(this, "Sucesso ao cadastrar", Toast.LENGTH_SHORT).show()
           }.addOnFailureListener {
               Toast.makeText(this, "Falha ao cadastrar", Toast.LENGTH_SHORT).show()
           }
       }

        binding.btnLogar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            autenticacao.signInWithEmailAndPassword(
                email, senha
            ).addOnSuccessListener {
                Toast.makeText(this, "Sucesso ao logar", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Falha ao logar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}