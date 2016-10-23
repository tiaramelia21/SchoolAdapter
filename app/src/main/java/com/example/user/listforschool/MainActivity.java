package com.example.user.listforschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnTeacher, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupStudent();
    }

    private void setupStudent() {
        Button btnStudent = (Button)findViewById(R.id.btnStudent);
        Button btnTeacher = (Button)findViewById(R.id.btnTeacher);

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(i);
            }
        });

        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(i);
            }
        });
    }
}
