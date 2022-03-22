package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {
CardView show_reviews;
CardView show_rides;
CardView log_out;
DatabaseHelper myDB=new DatabaseHelper(this);
CarDb cardb=new CarDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        show_reviews=(CardView)findViewById(R.id.showreview);
        show_rides=(CardView)findViewById(R.id.viewallrides);
        log_out=(CardView)findViewById(R.id.logout);
        show_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDB.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                int i = 1;
                while (res.moveToNext()) {
                    buffer.append(i+ " :"+ res.getString(1)+"\n");

                    i++;
                }


                // Show all data
                showMessage("Reviews",buffer.toString());
            }
        });
        show_rides.setOnClickListener(new View.OnClickListener() {
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
                    buffer.append(" Car code :"+ res.getString(0)+"\n");
                    buffer.append("---------------------------------"+"\n");

                    i++;
                }


                // Show all data
                showMessage("Rides",buffer.toString());
            }
        });
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(Admin.this,MainActivity.class);
                startActivity(ii);
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