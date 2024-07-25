package com.gnarlydinouser.calcii;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class cal extends AppCompatActivity {
    private TextView answer;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        answer = findViewById(R.id.ans);
        display=findViewById(R.id.et);

        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd){
        String oldStr=display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftstr = oldStr.substring(0,cursorPos);
        String rightstr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftstr,strToAdd,rightstr));
        display.setSelection(cursorPos + strToAdd.length());
    }
    public void zero(View view){
        updateText("0");
    }
    public void one(View view){
        updateText("1");
    }
    public void two(View view){
        updateText("2");
    }
    public void three(View view){
        updateText("3");
    }
    public void four(View view){
        updateText("4");
    }
    public void five(View view){
        updateText("5");
    }
    public void six(View view){
        updateText("6");
    }
    public void seven(View view){
        updateText("7");
    }
    public void eight(View view){
        updateText("8");
    }
    public void nine(View view){
        updateText("9");
    }
    public void clear(View view){
        display.setText("");
        answer.setText("0");
    }
    public void mod(View view){
        updateText("%");
    }
    public void lbr(View view){
        updateText("(");
    }
    public void rbr(View view){
        updateText(")");
    }
    public void back(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if(cursorPos!=0 && textLen!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void add(View view){
        updateText("+");
    }
    public void sub(View view){
        updateText("-");
    }
    public void mul(View view){
        updateText("*");
    }
    public void div(View view){
        updateText("/");
    }

    public void equal(View view){
        String userExp = display.getText().toString();
        answer.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.decimalText), "/");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void dot(View view){
        updateText(".");
    }
    public void sin(View view){
        updateText("sin(");
    }
    public void cos(View view){
        updateText("cos(");
    }
    public void tan(View view){
        updateText("tan(");
    }
    public void sini(View view){
        updateText("arcsin(");
    }
    public void cosi(View view){
        updateText("arccos(");
    }
    public void tani(View view){
        updateText("arctan(");
    }
    public void log(View view){
        updateText("log(");
    }
    public void ln(View view){
        updateText("ln(");
    }
    public void sqrt(View view){
        updateText("sqrt(");
    }
    public void e(View view){
        updateText("e");
    }
    public void pii(View view){
        updateText("pi");
    }
    public void fact(View view){
        updateText("!");
    }
    public void power(View view){
        updateText("^(");
    }
}