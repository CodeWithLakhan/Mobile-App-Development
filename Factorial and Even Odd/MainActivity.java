package com.example.factorialandevenodd;

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

    TextView soln;
    Button eo,fact;
    EditText no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        soln = findViewById(R.id.soln);
        eo = findViewById(R.id.eo);
        fact = findViewById(R.id.fact);
        no = findViewById(R.id.no);

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(no.getText().toString());
                int fact=1;
                for(int i=1;i<=num;i++) {
                    fact = fact * i;
                }
                soln.setText(Integer.toString(fact));
            }
        });

        eo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(no.getText().toString());
                if(num%2==0)
                {
                    soln.setText("Even");
                }
                else
                {
                    soln.setText("Odd");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
