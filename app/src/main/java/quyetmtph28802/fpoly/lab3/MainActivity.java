package quyetmtph28802.fpoly.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import quyetmtph28802.fpoly.lab3.Lab3_ex1.MainActivity_EX1;
import quyetmtph28802.fpoly.lab3.Lab3_ex2.MainActivity_EX2;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity_EX1.class));
            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity_EX2.class));
            }
        });
    }
}