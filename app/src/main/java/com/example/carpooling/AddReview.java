package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddReview extends AppCompatActivity {
CardView add_rev;
EditText txt_rev;
DatabaseHelper db;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        add_rev=(CardView)findViewById(R.id.Add_review_btn);
        txt_rev=(EditText)findViewById(R.id.Add_review_txt);
        db=new DatabaseHelper(this);
        add_rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertData(txt_rev.getText().toString());
                Toast.makeText(getApplicationContext(),"Thanks for your review",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddReview.this,home.class);
                startActivity(i);
            }
        });

    }
}