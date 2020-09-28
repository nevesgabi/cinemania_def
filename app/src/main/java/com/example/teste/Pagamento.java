package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pagamento extends AppCompatActivity {

    TextView txtCampoNome2;
    TextView txtCampoRg2;
    TextView txtCampoTipo2;
    TextView txtAcompanhamento3;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        txtCampoNome2 = (TextView)findViewById(R.id.txtCampoNome2);
        txtCampoRg2 = (TextView)findViewById(R.id.txtCampoRg2);
        txtCampoTipo2 = (TextView)findViewById(R.id.txtCampoTipo2);
        txtAcompanhamento3 = (TextView)findViewById(R.id.txtAcompanhamento3);


        Intent intentComprar = getIntent();

        Bundle parametros = intentComprar.getExtras();

        String name = parametros.getString("keyname");
        String rg = parametros.getString("keyrg");
        String tipo = parametros.getString("keytiposessao");
        String acompanhamento = parametros.getString("keyacompanhamento");
        txtCampoNome2.setText(name);
        txtCampoRg2.setText(rg);
        txtCampoTipo2.setText(tipo);
        txtAcompanhamento3.setText(acompanhamento);

    }

    public void Finalizar(View view){
        Intent intent = new Intent(this, Final.class);
        startActivity(intent);
    }
}