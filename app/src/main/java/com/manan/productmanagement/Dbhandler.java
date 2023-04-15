package com.manan.productmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Dbhandler extends SQLiteOpenHelper {
    public Dbhandler(@Nullable Context context) {
        super(context, "Product", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRO(PID INTEGER PRIMARY KEY AUTOINCREMENT,productname TEXT,producttype TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void insertdata(String name,String type)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("productname",name);
        contentValues.put("producttype",type);
        db.insert("PRO",null,contentValues);
    }
    public ArrayList<productModel> disalldata()
    {
        ArrayList<productModel>arr = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  PRO",null);
        if(cursor.moveToFirst())
        {
            do {
                arr.add(new productModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));

            }while (cursor.moveToNext());
        }
        cursor.close();
        return  arr;
    }
    public  void upatedata(String name1,String name,String type)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("productname",name);
        contentValues.put("producttype",type);
        sqLiteDatabase.update("PRO",contentValues,"productname = ?",new String[]{name1});
    }
    public void deletedata(String name)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete("PRO","productname = ?",new String[]{name});
    }
}
