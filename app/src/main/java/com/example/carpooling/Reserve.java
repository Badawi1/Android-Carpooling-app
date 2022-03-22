package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Reserve extends AppCompatActivity {
EditText carcode;
CardView book;
CarDb cardb=new CarDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        carcode=(EditText)findViewById(R.id.carcode);
        book=(CardView)findViewById(R.id.Book_btn);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carcode.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Car Code",Toast.LENGTH_SHORT).show();
                }

                else {
                    boolean flag = false;
                   Cursor res = cardb.getAllData();
                   int i =1;
                   while (res.moveToNext()) {
                       String code = res.getString(3);
                       if (code.equals(carcode.getText().toString())) {
                           flag = true;
                           break;
                       }
                   }
                   if(flag) {
                       Toast.makeText(getApplicationContext(), "Reserved", Toast.LENGTH_SHORT).show();
                       Intent home = new Intent(Reserve.this, com.example.carpooling.home.class);
                       Integer deletedride=cardb.deleteride(res.getString(0));
                       startActivity(home);
                   }
                       else{
                           Toast.makeText(getApplicationContext(),"Ride doesn't exist",Toast.LENGTH_SHORT).show();
                       }


                }
            }
        });
    }
}