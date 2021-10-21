package com.sdayazilim.insgram.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.sdayazilim.insgram.DataObjects.InsItem;
import com.sdayazilim.insgram.DataObjects.Profile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InsGramDB {

    SQLiteDatabase db;
    DBHelper dbHelper;
    Context LV_Context;

    public InsGramDB(Context context){
        dbHelper = new DBHelper(context);
        LV_Context = context;
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }

    public void addProfile(@NotNull Profile pObj){
        String sqlText= "INSERT INTO profiles (name, path, hide) VALUES (?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sqlText);
        db.beginTransaction();
        try {
            statement.clearBindings();
            statement.bindString(1, pObj.getName());
            statement.bindString(2, pObj.getPath());
            statement.bindLong(3, pObj.getHide());
            statement.execute();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public Profile getProfile(int pId){
        String[] columns = {"id","name","path","hide"};
        Cursor cursor = db.query("profiles", columns, "id=?", new String[]{String.valueOf(pId)},null,null, "id DESC");
        Profile obj = new Profile();
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            obj.setId(cursor.getInt(0));
            obj.setName(cursor.getString(1));
            obj.setPath(cursor.getString(2));
            obj.setHide(cursor.getInt(3));
            cursor.close();
        }
        return  obj;
    }

    public void deleteProfile(int pId){
        db.delete("profiles", "id=?", new String[]{String.valueOf(pId)});
    }

    public void addItem(@NotNull InsItem pObj){
        String sqlText= "INSERT INTO downloads (pId, date, url, duration, caption, thumbPath, path, hide, isVideo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sqlText);
        db.beginTransaction();
        try {
            statement.clearBindings();
            statement.bindLong(1, pObj.getProfileId());
            statement.bindString(2, pObj.getDate());
            statement.bindString(3, pObj.getUrl());
            statement.bindString(4, pObj.getDuration());
            statement.bindString(5, pObj.getCaption());
            statement.bindString(6, pObj.getThumbPath());
            statement.bindString(7, pObj.getPath());
            statement.bindLong(8, pObj.getHide());
            statement.bindLong(9, pObj.getVideo());
            statement.execute();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public InsItem getItem(int pId){
        String[] columns = {"id", "pId", "date", "url", "duration", "caption", "thumbPath", "path", "hide", "isVideo"};
        Cursor cursor = db.query("downloads", columns, "id=?", new String[]{String.valueOf(pId)},null,null, "id DESC");
        InsItem obj = new InsItem();
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            obj.setId(cursor.getInt(0));
            obj.setProfileId(cursor.getInt(1));
            obj.setDate(cursor.getString(2));
            obj.setUrl(cursor.getString(3));
            obj.setDuration(cursor.getString(4));
            obj.setCaption(cursor.getString(5));
            obj.setThumbPath(cursor.getString(6));
            obj.setPath(cursor.getString(7));
            obj.setHide(cursor.getInt(8));
            obj.setVideo(cursor.getInt(9));
            cursor.close();
        }
        return  obj;
    }

    public List<InsItem> getItems(int pId){
        List<InsItem> list = new ArrayList<>();
        String[] columns = {"id", "pId", "date", "url", "duration", "caption", "thumbPath", "path", "hide", "isVideo"};
        Cursor cursor = db.query("downloads", columns, "id=?", new String[]{String.valueOf(pId)},null,null, "id DESC");
        InsItem obj;
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for (int i=0; i<cursor.getCount(); i++){
                obj = new InsItem();
                obj.setId(cursor.getInt(0));
                obj.setProfileId(cursor.getInt(1));
                obj.setDate(cursor.getString(2));
                obj.setUrl(cursor.getString(3));
                obj.setDuration(cursor.getString(4));
                obj.setCaption(cursor.getString(5));
                obj.setThumbPath(cursor.getString(6));
                obj.setPath(cursor.getString(7));
                obj.setHide(cursor.getInt(8));
                obj.setVideo(cursor.getInt(9));
                list.add(obj);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return  list;
    }

    public void deleteItem(int pId){
        db.delete("downloads", "id=?", new String[]{String.valueOf(pId)});
    }

}
