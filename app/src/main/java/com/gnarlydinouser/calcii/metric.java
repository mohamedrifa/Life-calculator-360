package com.gnarlydinouser.calcii;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class metric extends AppCompatActivity {

    RadioGroup radio;
    RadioButton radioButton;
    TextView statement;
    EditText age;
    EditText pound;
    EditText feet;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric);
        statement = findViewById(R.id.stat);
        age=findViewById(R.id.a);
        pound=findViewById(R.id.po);
        radio=findViewById(R.id.radio);
        feet=findViewById(R.id.fe);
        calculate=findViewById(R.id.cal);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bmi=0;
                int ID=radio.getCheckedRadioButtonId();
                String a = String.valueOf(age.getText());
                int ag = a.matches("\\d+") ? Integer.parseInt(a) : 0;
                String p = String.valueOf(pound.getText());
                int po = p.matches("\\d+") ? Integer.parseInt(p) : 0;
                String f = String.valueOf(feet.getText());
                int fe = f.matches("\\d+") ? Integer.parseInt(f) : 0;
                radioButton=findViewById(ID);
                statement.setText("selected: "+ID);
                if(ID == 2131231253)
                    bmi = (po / (fe * fe)) * 703;
                else
                    bmi = (po / (fe * fe)) * 703-2;
                if (bmi < 18.5) {
                    statement.setText("Statement: You are underweight.\n");
                } else if (bmi < 25) {
                    statement.setText("Statement: You have a normal weight.\n");
                } else if (bmi < 30) {
                    statement.setText("Statement: You are overweight.\n");
                } else {
                    statement.setText("Statement: You are obese.\n");
                }
                if (ag < 18) {
                    statement.setText("Statement: Note: BMI categories for children and teenagers may differ.\n");
                }
                if (ag > 70) {
                    statement.setText("Statement: Note: Age you entered is too high\n");
                }
                if(bmi==0)
                    statement.setText("");
            }
        });
    }
    public void clean(View v){
        age.setText("");
        feet.setText("");
        pound.setText("");
    }
    public void us(View v){
        Intent i = new Intent(this, BMI.class);
        Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(i,b);
    }
}