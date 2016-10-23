package com.example.user.listforschool;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EditStudentActivity extends AppCompatActivity implements Serializable{
    private EditText editNo, editNoreg, editNama, editEmail, editTelp;
    private FloatingActionButton btnEdit, btnCancel;
    private boolean isEdit = false;
    ArrayList<Student> students;
    private int position;//save posisi object

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        students = StudentActivity.students;

        editNo = (EditText)findViewById(R.id.editNo);
        editNoreg = (EditText)findViewById(R.id.editNoreg);
        editNama = (EditText)findViewById(R.id.editNama);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editTelp = (EditText)findViewById(R.id.editTelp);

        Intent i = getIntent();
        if(i.getBooleanExtra("isEdit", true)){
            isEdit = true;
            Student student = (Student)i.getSerializableExtra("student");
            editNo.setText(String.valueOf(student.getNoS()));
            editNoreg.setText(student.getNoregS());
            editNama.setText(student.getNamaS());
            editEmail.setText(student.getEmailS());
            editTelp.setText(student.getTelponS());
            position = i.getIntExtra("position", 0);
        }else {
            editNo.setText(String.valueOf(students.size()));
        }

        btnCancel = (FloatingActionButton)findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEdit = (FloatingActionButton)findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });
    }

    private void simpan() {
        if (isEdit){
            Student tmp = new Student(Integer.parseInt(
                    editNo.getText().toString()),
                    editNoreg.getText().toString(),
                    editNama.getText().toString(),
                    editEmail.getText().toString(),
                    editTelp.getText().toString());
            students.set(position, tmp);
            finish();
        }else {
            Student tmp = new Student(Integer.parseInt(
                    editNo.getText().toString()),
                    editNoreg.getText().toString(),
                    editNama.getText().toString(),
                    editEmail.getText().toString(),
                    editTelp.getText().toString());
            students.add(tmp);
            finish();
        }
    }
}
