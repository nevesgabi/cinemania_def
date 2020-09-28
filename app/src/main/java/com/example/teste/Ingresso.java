package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ingresso extends AppCompatActivity {

    Button btnComprar;
    EditText CampoNome;
    EditText CampoRG;
    RadioGroup sessao;
    CheckBox check_acompanhamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresso);
        CampoNome = (EditText) findViewById(R.id.txtCampoNome);
        CampoRG = (EditText) findViewById(R.id.txtCampoRG);
        sessao = (RadioGroup) findViewById(R.id.sessao);
        check_acompanhamento = (CheckBox) findViewById(R.id.check_acompanhamento);
        btnComprar =(Button) findViewById(R.id.btnComprar);
    }

    public void Comprar(View view){
        String txtCampoNome = CampoNome.getText().toString();
        String txtCampoRG = CampoRG.getText().toString();

        int selectedId = sessao.getCheckedRadioButtonId();
        RadioButton tiposessao = (RadioButton) findViewById(selectedId);

        Intent intentComprar = new Intent(getApplicationContext(), Pagamento.class);
        Bundle parametros = new Bundle();

        parametros.putString("keyname", txtCampoNome);
        parametros.putString("keyrg", txtCampoRG);

        parametros.putString("keytiposessao",tiposessao.getText().toString());
        parametros.putString("keyacompanhamento", check_acompanhamento.isChecked()?"Com acompanhamento":"Sem acompanhamento");

        intentComprar.putExtras(parametros);
        startActivity(intentComprar);
    }
}