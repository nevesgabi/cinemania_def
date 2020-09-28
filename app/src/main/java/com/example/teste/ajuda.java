package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ajuda extends AppCompatActivity {

    ImageButton btnTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        btnTel = (ImageButton) findViewById (R.id.btnTel);
    }

    public void LigarTel(View view){
        Intent liga = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:40028922"));
        startActivity(liga);
    }

    public void MandarEmail(View view) throws UnsupportedEncodingException {
        String uriText = "mailto:cinemania2020@gmail.com"+"?subject=" + URLEncoder.encode("Informe o assunto","utf-8")+"&body" +URLEncoder.encode("Desenvolva","utf-8");
        Uri uri = Uri.parse(uriText);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        startActivity(intent);
    }
}