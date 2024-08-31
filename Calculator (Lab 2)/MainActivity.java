package com.example.a1stcalculator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText n1,n2;
    TextView result;
    Button button,sub,mul,div;
    int num1=0,num2=0,ans=0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        result = findViewById(R.id.result);
        button = findViewById(R.id.button);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(n1.getText().toString());
                num2 = Integer.parseInt(n2.getText().toString());
                ans = num1+num2;
                result.setText(Integer.toString(ans));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(n1.getText().toString());
                num2 = Integer.parseInt(n2.getText().toString());
                ans = num1-num2;
                result.setText(Integer.toString(ans));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(n1.getText().toString());
                num2 = Integer.parseInt(n2.getText().toString());
                ans = num1*num2;
                result.setText(Integer.toString(ans));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(n1.getText().toString());
                num2 = Integer.parseInt(n2.getText().toString());
                float div=0;

                div = (float)num1/(float)num2;
                result.setText(Float.toString(div));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
