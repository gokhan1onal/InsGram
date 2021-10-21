package com.sdayazilim.insgram.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sdayazilim.insgram.DataObjects.InsGram;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "InsGram", null, InsGram.DatabaseVersion);
    }

    String profileCreateSql = "create table if not exists profiles (id integer PRIMARY KEY AUTOINCREMENT, name text not null, path text not null, hide integer not null)";
    String downloadsCreateSql = "create table if not exists downloads (id integer PRIMARY KEY AUTOINCREMENT, pId integer not null, date text not null, url text not null, duration text not null, caption text not null, thumbPath text not null, path text not null, hide integer not null, isVideo integer not null)";

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL(profileCreateSql);
        db.execSQL(downloadsCreateSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* if (oldVersion <= 2) {
            db.execSQL(downloadsCreateSql);
        } */
    }

}
