package com.gnarlydinouser.calcii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bmi(View v){
        Intent i = new Intent(this, BMI.class);
        startActivity(i);
    }
    public void pay(View v){
        Intent j = new Intent(this, payment.class);
        startActivity(j);
    }
    public void cal(View v){
        Intent k = new Intent(this, cal.class);
        startActivity(k);
    }

}