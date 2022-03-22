package com.example.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.lang.UScript;

import androidx.annotation.Nullable;

public class UserDHhelper extends SQLiteOpenHelper {
private  static String DBname="userDataSase";
SQLiteDatabase UserDataBase;

    public UserDHhelper(Context context){
        super(context,DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(id integer primary key autoincrement,"+"username text not null,password text not null,review text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("drop table if exists user");


onCreate(db);
    }
    public void adduser(String username,String password){
        ContentValues row=new ContentValues();
        row.put("username",username);
        row.put("password",password);
        UserDataBase = getWritableDatabase();
        UserDataBase.insert("user",null,row);
        UserDataBase.close();
    }

    public boolean correct_pass(String username,String password) {
        UserDataBase = getReadableDatabase();
        String[] arg = {username};
        Cursor cursor = UserDataBase.rawQuery("SELECT password fROM user WHERE username LIKE ?", arg);
        cursor.moveToFirst();
        if (password.equals(cursor.getString(0))) {
            UserDataBase.close();
            return true;
        } else{
            UserDataBase.close();
        return false;
    }
    }

    public boolean userexists(String username){
        UserDataBase=getReadableDatabase();
        String [] arg={username};
        Cursor cursor = UserDataBase.rawQuery("SELECT * FROM user WHERE username LIKE ?",arg);
        int count = cursor.getCount();
        UserDataBase.close();
        if(count>0){

             return true;
        }
            else
            return false;
    }
    public Cursor fetchallusers(){
UserDataBase =getReadableDatabase();
String [] rowdetails ={"username","password","id,review"};
Cursor cursor = UserDataBase.query("user",rowdetails,null,null,null,null,null);
if(cursor !=null)
    cursor.moveToFirst();
UserDataBase.close();
return cursor;

    }

}
