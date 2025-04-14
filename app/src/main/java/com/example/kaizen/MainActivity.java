package com.example.kaizen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoEmail, campoSenha;
    Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoEmail = findViewById(R.id.campo_email);
        campoSenha = findViewById(R.id.campo_senha);
        botaoEntrar = findViewById(R.id.botao_entrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = campoEmail.getText().toString().trim().toLowerCase();
                String senha = campoSenha.getText().toString().trim();

                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (email.equals("fcasagrandi38@gmail.com") && senha.equals("5516")) {
                        Intent intent = new Intent(MainActivity.this, ListaTarefasActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
