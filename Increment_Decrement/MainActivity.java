package com.example.increment_decrement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView num;
    Button binc,bdec;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        binc = findViewById(R.id.binc);
        bdec = findViewById(R.id.bdec);

        binc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n++;
                num.setText(Integer.toString(n));
                Toast.makeText(getApplicationContext(),"Incremented",Toast.LENGTH_LONG).show();
            }
        });
        bdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n--;
                num.setText(Integer.toString(n));
                Toast.makeText(getApplicationContext(),"Decremented",Toast.LENGTH_LONG).show();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
