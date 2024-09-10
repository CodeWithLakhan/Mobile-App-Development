package com.example.seriessumandintent;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    EditText num;
    TextView soln;
    Button bt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        soln = findViewById(R.id.soln);
        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float s=0;
                float n = Integer.parseInt(num.getText().toString());
                if(n>0)
                {
                    for(float i=1;i<=n;i++)
                    {
                        s = s + (1/i);
                    }
                    soln.setText(Float.toString(s));
                }
                else
                {
                    soln.setText("Please Enter Value Greater than 0");
                }
                String ss = Float.toString(s);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("soln",ss);
                startActivity(intent);
            }
        });

        Intent intentt = getIntent();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}