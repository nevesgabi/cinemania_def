package com.example.teste;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnlogar, btnAjuda;
    EditText txtCampoUsuario;
    EditText txtCampoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogar = (Button) findViewById(R.id.btnlogar);
        btnAjuda = (Button) findViewById(R.id.btnAjuda);
        txtCampoUsuario = (EditText) findViewById(R.id.txtCampoUsuario);
        txtCampoSenha = (EditText) findViewById(R.id.txtCampoSenha);
    }

    public void Help(View view) {

        Intent intent = new Intent(this, ajuda.class);
        startActivity(intent);
    }

    public void Cad(View view) {

        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    public void Logar(View view) {

        String user = txtCampoUsuario.getText().toString();
        String senha = txtCampoSenha.getText().toString();

        if (TextUtils.isEmpty(user)) {
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("Aviso");
            dig.setMessage("Confira se o usuário está completo");
            dig.setNeutralButton("OK", null);
            dig.show();
        } else if (TextUtils.isEmpty(senha)) {
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("Aviso");
            dig.setMessage("Confira se a senha está completa");
            dig.setNeutralButton("OK", null);
            dig.show();
        } else {
            Intent intentEntrar = new Intent(getApplicationContext(), menu.class);
            startActivity(intentEntrar);
        }
    }
}

