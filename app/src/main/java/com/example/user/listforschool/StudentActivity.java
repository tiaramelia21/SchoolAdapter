package com.example.user.listforschool;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    public static ArrayList<Student> students;
    private ListView listViewStudent;
    private TextView noStudent;
    private StudentArrayAdapter studentArrayAdapter;
    private FloatingActionButton btnAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        if (students == null){
            students = new ArrayList<Student>();
        }

        studentArrayAdapter = new StudentArrayAdapter(this, students);
        listViewStudent = (ListView)findViewById(R.id.listViewStudent);
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentss = students.get(position);
                Intent i = new Intent(StudentActivity.this, EditStudentActivity.class);
                i.putExtra("student", (Serializable) studentss);
                i.putExtra("isEdit", true);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

        btnAddStudent = (FloatingActionButton)findViewById(R.id.btnAddStudent);
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentActivity.this, EditStudentActivity.class);
                i.putExtra("isEdit", false);
                startActivity(i);
            }
        });
    }

    public void createDummy(){
        int i = students.size();
        students.add(new Student(i, "3135136211", "Tiara Amelia", "tiara21.amelia@gmail.com", "081282003420"));

    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView noStudent = (TextView)findViewById(R.id.noStudent);
        if(students.size() > 0){
            noStudent.setText("");
            studentArrayAdapter = new StudentArrayAdapter(this, students);
        }else {
            studentArrayAdapter = new StudentArrayAdapter(this, students);
            listViewStudent.setEmptyView(noStudent);
            noStudent.setText("No Student Data Found");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_list_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.createDummy:
                createDummy();
                break;
            case R.id.clear:
                students.clear();
                break;
        }
        studentArrayAdapter = new StudentArrayAdapter(this, students);
        listViewStudent.setAdapter(studentArrayAdapter);
        return super.onOptionsItemSelected(item);
    }


}
