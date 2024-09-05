package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ed1=(EditText)findViewById(R.id.et1);
        ed2=(EditText)findViewById(R.id.et2);
        result=(TextView) findViewById(R.id.tv);

    }
    public void Add(View view) {
        double num1=Double.parseDouble(ed1.getText().toString());
        double num2=Double.parseDouble(ed2.getText().toString());
        double sum=num1+num2;
        result.setText(""+sum);
   }

    public void Sub(View view) {
        double num1=Double.parseDouble(ed1.getText().toString());
        double num2=Double.parseDouble(ed2.getText().toString());
        double sub=num1-num2;
        result.setText(""+sub);
    }

    public void Mul(View view) {
        double num1=Double.parseDouble(ed1.getText().toString());
        double num2=Double.parseDouble(ed2.getText().toString());
        double mul=num1*num2;
        result.setText(""+mul);
    }

    public void Div(View view) {
        double num1=Double.parseDouble(ed1.getText().toString());
        double num2=Double.parseDouble(ed2.getText().toString());
        double div=num1/num2;
        result.setText(""+div);
    }
}