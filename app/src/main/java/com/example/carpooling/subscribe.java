package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class subscribe extends AppCompatActivity {
    android.widget.Button Button, Button2, Button3;
    EditText et_prec;
    SubscribeDataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
        et_prec = findViewById(R.id.subscribtion);

        db = new SubscribeDataBaseHelper(this);

        android.widget.Button btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subscription subscription;
                try {
                    subscription = new Subscription("Subscribed", "UnSubscribed", et_prec.getText().toString());
                    if(et_prec.getText().toString().equals("25")||et_prec.getText().toString().equals("50")||et_prec.getText().toString().equals("75"))
                    {
                        db.addData((et_prec).getText());
                        Toast.makeText(subscribe.this, "Promo Code Is Activiated", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(subscribe.this,home.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(subscribe.this, "Percentage Is Wrong, Please Enter Again", Toast.LENGTH_SHORT).show();
                        et_prec.setText("");

                    }

                } catch (Exception e) {
                    Toast.makeText(subscribe.this, "Error in Subscribing", Toast.LENGTH_SHORT).show();
                    subscription = new Subscription("error", "error", "error");
                }
                SubscribeDataBaseHelper subscribeDataBaseHelper = new SubscribeDataBaseHelper(subscribe.this);
                //boolean Success = db.addData((et_prec).getText());
                //Toast.makeText(MainActivity.this, "Success" + Success, Toast.LENGTH_SHORT).show();
                et_prec.setText("");
            }
        });

    }
}