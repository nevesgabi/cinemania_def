package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText txtNomeCad;
    private EditText txtEmailCad;
    private EditText txtUserCad;
    private EditText txtSenhaCad;
    private AcessoUsuario acesso;
    Button btnAjuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnAjuda = findViewById(R.id.btnAjuda);
        txtNomeCad = findViewById(R.id.txtNomeCad);
        txtEmailCad = findViewById(R.id.txtEmailCad);
        txtUserCad = findViewById(R.id.txtUserCad);
        txtSenhaCad = findViewById(R.id.txtSenhaCad);
        acesso = new AcessoUsuario(this);
    }
    public void Cadastrar(View view){
        Usuario us = new Usuario();
        us.setNome(txtNomeCad.getText().toString());
        us.setEmail(txtEmailCad.getText().toString());
        us.setUser(txtUserCad.getText().toString());
        us.setSenha(txtSenhaCad.getText().toString());
        long id = acesso.inserir(us);
        Toast.makeText(this, "Usuario cadastrado: id "+id, Toast.LENGTH_SHORT).show();
    }

    public void Help (View view) {
        Intent intent = new Intent(this, ajuda.class);
        startActivity(intent);
    }
}