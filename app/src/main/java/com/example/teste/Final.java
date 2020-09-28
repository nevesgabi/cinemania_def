package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Final extends AppCompatActivity {
    Button btnVoltar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        btnVoltar3 = (Button) findViewById(R.id.btnVoltar3);
    }

    public void Voltar(View view){

        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }
}