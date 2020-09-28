package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class menu extends AppCompatActivity {
    Button btnPerfil, btnSobre, btnCatalogo, btnComprarIng, btnLancamento, btnLocalizacao;
    ImageButton btnTel2, btnEmail2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnPerfil = (Button) findViewById(R.id.btnPerfil);
        btnSobre = (Button) findViewById(R.id.btnSobre);
        btnCatalogo = (Button) findViewById(R.id.btnCatalogo);
        btnComprarIng = (Button) findViewById(R.id.btnComprarIng);
        btnLancamento = (Button) findViewById(R.id.btnLancamento);
        btnLocalizacao = (Button) findViewById(R.id.btnLocalizacao);
        btnTel2 = (ImageButton) findViewById (R.id.btnTel2);
        btnEmail2 = (ImageButton) findViewById(R.id.btnEmail2);
    }

    public void Perfil (View view) {

        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    public void Sobre(View view){
        Intent intent = new Intent(this, Sobre.class);
        startActivity(intent);
    }

    public void Catalogo(View view){
        Intent intent = new Intent(this, Catalogo.class);
        startActivity(intent);
    }

    public void Ingresso(View view){
        Intent intent=new Intent(this, Ingresso.class);
        startActivity(intent);
    }

    public void Lancamento(View view){
        Intent intent = new Intent (this, lancamentos.class);
        startActivity(intent);
    }

    public void MinhaLocalizacao(View view){
        Intent intent = new Intent (this, Localizacao.class);
        startActivity(intent);
    }

    public void Ligar(View view){
        Intent liga = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:40028922"));
        startActivity(liga);
    }

    public void Localizacao(View view){
        Intent encontra = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Av.+dos+Autonomistas,+89+-+Vila+Yara,+Osasco+-+SP"));
        startActivity(encontra);
    }

    public void Email(View view) throws UnsupportedEncodingException {
        String uriText = "mailto:cinemania2020@gmail.com"+"?subject=" + URLEncoder.encode("Informe o assunto","utf-8")+"&body" +URLEncoder.encode("Desenvolva","utf-8");
        Uri uri = Uri.parse(uriText);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        startActivity(intent);
    }
}