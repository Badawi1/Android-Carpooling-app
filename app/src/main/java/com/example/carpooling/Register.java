package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
EditText usrname;
EditText usrpass;
EditText cnf_pass;
CardView reg_btn;
UserDHhelper db=new UserDHhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usrname=(EditText)findViewById(R.id.username);
        usrpass=(EditText)findViewById(R.id.password);
        cnf_pass=(EditText)findViewById(R.id.cnf_password);
        reg_btn=(CardView)findViewById(R.id.register_btn);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name,pass,confirm;
                user_name=usrname.getText().toString();
                pass=usrpass.getText().toString();
                confirm=cnf_pass.getText().toString();
                if(db.userexists(user_name)){
                    Toast.makeText(getApplicationContext(),"Username already exists",Toast.LENGTH_LONG).show();

                }
                else if(!pass.equals(confirm)){
                    Toast.makeText(getApplicationContext(),"Password doesn't match",Toast.LENGTH_LONG).show();
                }
                else if(user_name.equals("")||pass.equals("")||cnf_pass.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter empty fields",Toast.LENGTH_LONG).show();

                }
                else{
                    db.adduser(user_name,pass);
                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_LONG).show();
Intent i = new Intent(Register.this,MainActivity.class);
startActivity(i);
                }
            }
        });
    }
}