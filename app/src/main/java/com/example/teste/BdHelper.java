package com.example.teste;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHelper extends SQLiteOpenHelper {

    private static final String name = "cinema.db";
    private static final int version = 1;


    public BdHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(id_usuario integer primary key autoincrement, "+
                " nome_usuario varchar(80), email_usuario varchar(80), user_usuario varchar(50), senha_usuario varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
