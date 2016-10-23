package com.example.user.listforschool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by User on 23-Oct-16.
 */

public class StudentArrayAdapter extends ArrayAdapter<Student>{
    public StudentArrayAdapter(Context context, ArrayList<Student> studentList) {
        super(context, 0, studentList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_student, parent, false);
        }

        TextView noS = (TextView)convertView.findViewById(R.id.noS);
        TextView noregS = (TextView)convertView.findViewById(R.id.noregS);
        TextView namaS = (TextView)convertView.findViewById(R.id.namaS);
        TextView emailS = (TextView)convertView.findViewById(R.id.emailS);
        TextView telponS = (TextView)convertView.findViewById(R.id.telponS);

        noS.setText(student.getNoS()+"");
        noregS.setText(student.getNoregS());
        namaS.setText(student.getNamaS());
        emailS.setText(student.getEmailS());
        telponS.setText(student.getTelponS());

        return convertView;
    }
}
