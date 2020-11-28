package com.example.teste;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AcessoUsuario {

    private BdHelper bdHelper;
    private SQLiteDatabase cinema;

    public AcessoUsuario(Context context){
        bdHelper = new BdHelper(context);
        cinema = bdHelper.getWritableDatabase();
    }

    public long inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome_usuario",usuario.getNome() );
        values.put("email_usuario", usuario.getEmail());
        values.put("user_usuario", usuario.getUser());
        values.put("senha_usuario", usuario.getSenha());
        return cinema.insert("usuario", null, values);
    }
}
