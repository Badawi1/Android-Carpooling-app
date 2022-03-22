package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carpooling.CarDb;
import com.example.carpooling.R;

public class addridee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addridee);
        final CardView done= (CardView) findViewById(R.id.addride_btn);
        final EditText start = (EditText)findViewById(R.id.location);
        final EditText destination = (EditText)findViewById(R.id.destination);
        final EditText code = (EditText)findViewById(R.id.carcode);

        final CarDb newcar =  new CarDb(this);


        done.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
if(start.getText().toString().equals("")||destination.getText().toString().equals("")||code.getText().toString().equals("")){
    Toast.makeText(getApplicationContext(),"Please enter empty fields",Toast.LENGTH_SHORT).show();
}

else {
    boolean flag = false;
    Cursor res = newcar.getAllData();
    while (res.moveToNext()) {
        String car_code = res.getString(3);
        if (car_code.equals(code.getText().toString())) {
            flag = true;
            break;
        }
    }
    if(flag){
        Toast.makeText(getApplicationContext(),"Code already exists",Toast.LENGTH_SHORT).show();
    }else {
        newcar.insertData(start.getText().toString(), destination.getText().toString(), code.getText().toString());
        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        Intent i = new Intent(addridee.this, home.class);
        startActivity(i);
    }
}
            }
        });


    }

}
