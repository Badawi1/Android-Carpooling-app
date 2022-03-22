package com.example.carpooling;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import androidx.annotation.Nullable;

import java.util.concurrent.Flow;

public class SubscribeDataBaseHelper extends SQLiteOpenHelper {
    public static final String SUBSCRIP_TABLE = "SUBSCRIP_TABLE";
    public static final String COLUMN_ID = "ID";
    //public static final String COLUMN_SUB = "SUB";
    //public static final String COLUMN_UNSUB = "UNSUB";
    public static final String COLUMN_SUB_PREC = "SUBPERC";

    public SubscribeDataBaseHelper(@Nullable Context context) {
        super(context, "subscript.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableStatment = "CREATE TABLE "+SUBSCRIP_TABLE+ " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_SUB_PREC + " TEXT )";
        db.execSQL(CreateTableStatment);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean Sub(Subscription sub){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Subscription s=new Subscription();
        //cv.put(COLUMN_SUB ,sub.getSub());
        //cv.put(COLUMN_UNSUB ,sub.getUnsub());
        cv.put(COLUMN_SUB_PREC ,sub.getPrec());
        Long insert = db.insert(SUBSCRIP_TABLE,null , cv);
        if (insert != -1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean addData(Editable item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(COLUMN_SUB_PREC, String.valueOf(item));

        //Log.d(TAG, "addData: Adding" + item + "to" + SUBSCRIP_TABLE);
        long result = db.insert(SUBSCRIP_TABLE, null, CV);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

}
