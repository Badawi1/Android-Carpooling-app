package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class Book_ride extends AppCompatActivity {
CardView show;
CardView book;
CarDb cardb=new CarDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ride);
        show=(CardView)findViewById(R.id.showrides_btn);
        book=(CardView)findViewById(R.id.reserve_btn);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = cardb.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                int i = 1;
                while (res.moveToNext()) {
                    buffer.append(i+ " Location :"+ res.getString(1)+"\n");
                    buffer.append(" Destination :"+ res.getString(2)+"\n");
                    buffer.append(" Car code :"+ res.getString(3)+"\n");
                    buffer.append("---------------------------------"+"\n");

                    i++;
                }


                // Show all data
                showMessage("Rides",buffer.toString());

            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent book_page=new Intent(Book_ride.this,Reserve.class);
                startActivity(book_page);
            }
        });

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}