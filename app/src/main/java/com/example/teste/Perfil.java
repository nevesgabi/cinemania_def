package com.example.teste;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class Perfil extends AppCompatActivity {
    ImageView imgFoto;
    String picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        if(ActivityCompat.checkSelfPermission(Perfil.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Perfil.this, new String[] {Manifest.permission.CAMERA}, 0);
        }
        imgFoto = findViewById(R.id.imgFoto);
        this.picturePath = this.getExternalFilesDir("png").toString() + "picture.png";

        File picture = new File(this.picturePath);
        if(picture.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(this.picturePath);
            imgFoto.setImageBitmap(bitmap);
        }

    }

    public void CapturarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    public void Captura (View view){
        CapturarFoto();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode ==1 && resultCode== RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imgFoto.setImageBitmap(imagem);
            try {
                File file = new File(picturePath);
                if(file.exists())
                    file.delete();
                FileOutputStream output = new FileOutputStream(file);
                imagem.compress(Bitmap.CompressFormat.PNG, 100, output);
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
}
}