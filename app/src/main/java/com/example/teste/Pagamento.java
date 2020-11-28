package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Pagamento extends AppCompatActivity {

    TextView txtCampoNome2;
    TextView txtCampoRg2;
    TextView txtCampoTipo2;
    TextView txtAcompanhamento3;
    Button btnFinalizar;
    RadioGroup pagamento;
    RadioGroup ingresso;
    RadioButton radiopag;
    RadioButton radioing;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        txtCampoNome2 = (TextView)findViewById(R.id.txtCampoNome2);
        txtCampoRg2 = (TextView)findViewById(R.id.txtCampoRg2);
        txtCampoTipo2 = (TextView)findViewById(R.id.txtCampoTipo2);
        txtAcompanhamento3 = (TextView)findViewById(R.id.txtAcompanhamento3);
        ingresso = (RadioGroup) findViewById(R.id.radioingresso);
        pagamento = (RadioGroup) findViewById(R.id.radiopg);
        prefs = getSharedPreferences("minhaPrefs", Context.MODE_PRIVATE);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = pagamento.getCheckedRadioButtonId();
                int selectId = ingresso.getCheckedRadioButtonId();
                radiopag = (RadioButton) findViewById(selectedId);
                radioing=(RadioButton)findViewById(selectId);
                SharedPreferences.Editor editor = prefs.edit();
                String ing = radioing.getText().toString();
                String pag = radiopag.getText().toString();
                editor.putString("ing_key",ing);
                editor.putString("pag_key", pag);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Tipo de pagamento escolhido: "+pag+" e tipo de ingresso: "+ing, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Pagamento.this, Final.class);
                startActivity(intent);
            }
        });


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

    //public void Finalizar(View view){
      //  Intent intent = new Intent(this, Final.class);
        //startActivity(intent);
   // }


}