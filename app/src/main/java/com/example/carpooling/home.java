package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {
CardView add_ride;
CardView book_ride;
CardView add_rev;
CardView logout;
CardView subscribe;
CardView show;
UserDHhelper db=new UserDHhelper(this);
DatabaseHelper myDB = new DatabaseHelper(this);
    CarDb newcar =  new CarDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        add_ride=(CardView)findViewById(R.id.addride_btn);
        subscribe=(CardView)findViewById(R.id.subscribe_btn);
        book_ride=(CardView)findViewById(R.id.Book_btn);
        add_rev=(CardView)findViewById(R.id.addreview_btn);
        logout=(CardView)findViewById(R.id.logout_btn);
        show=(CardView)findViewById(R.id.showreview) ;
        add_rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addrev = new Intent(home.this,AddReview.class);
                startActivity(addrev);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log_out=new Intent(home.this,MainActivity.class);
                startActivity(log_out);
            }
        });
        add_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addcarr=new Intent(home.this,addridee.class);
                startActivity(addcarr);
            }
        });

subscribe.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent sub=new Intent(home.this,subscribe.class);
startActivity(sub);

    }
});
show.setOnClickListener(new View.OnClickListener() {
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

book_ride.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent book=new Intent(home.this,Book_ride.class);
        startActivity(book);
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