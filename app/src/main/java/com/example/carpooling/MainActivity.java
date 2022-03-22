package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Username;
    EditText Pass;
    TextView Register;
    CardView Card;
    UserDHhelper db = new UserDHhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username=(EditText)findViewById(R.id.username);
        Register=(TextView) findViewById(R.id.txt_register);
        Pass=(EditText)findViewById(R.id.password);
        Card=(CardView)findViewById(R.id.sign_in_btn);

        Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name,password;
                user_name=Username.getText().toString();
                password=Pass.getText().toString();
                if(user_name.equals("Admin")&&password.equals("Admin")){
                    Toast.makeText(getApplicationContext(),"Logged in as Admin",Toast.LENGTH_LONG).show();
                    Intent admin=new Intent(MainActivity.this,Admin.class);
                    startActivity(admin);
                }
                else if(user_name.equals("")||password.equals("")){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_LONG).show();
                }
                else if(!db.userexists(user_name)){
                    Toast.makeText(getApplicationContext(),"Username doesn't exist",Toast.LENGTH_LONG).show();
                    Username.setText("");
                    Pass.setText("");

                }
                else if(!db.correct_pass(user_name,password)){
                    Toast.makeText(getApplicationContext(),"Incorrect password",Toast.LENGTH_LONG).show();
                    Pass.setText("");

                }

                else
                    {
                    Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,home.class);
                    startActivity(i);
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(MainActivity.this,Register.class);
                startActivity(reg);
            }
        });


    }
}