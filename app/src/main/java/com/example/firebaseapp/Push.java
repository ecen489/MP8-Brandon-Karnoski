package com.example.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Push extends AppCompatActivity {
    FirebaseDatabase fbdb;
    DatabaseReference dbrf;
    int radioID = R.id.rad_ralph;
    int dbID = 404;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        fbdb = FirebaseDatabase.getInstance();
        dbrf = fbdb.getReference();

    }

    public void radioClick(View view) {
        radioID = view.getId();
        if(radioID==R.id.rad_bart){dbID = 123;}
        if(radioID==R.id.rad_ralph){dbID = 404;}
        if(radioID==R.id.rad_milhouse){dbID = 456;}
        if(radioID==R.id.rad_lisa){dbID = 888;}
    }

    public void push(View view){
        EditText courseID_Text = findViewById(R.id.courseIDedit);
        EditText courseNameText = findViewById(R.id.courseNameEdit);
        EditText gradeEdit = findViewById(R.id.grade);

        String ID = courseID_Text.getText().toString();
        String name = courseNameText.getText().toString();
        String grade = gradeEdit.getText().toString();

        DatabaseReference passName = dbrf.child("simpsons/students/" + Integer.toString(dbID) +"/course_name");
        passName.setValue(name);
        DatabaseReference passID = dbrf.child("simpsons/students/" + Integer.toString(dbID) +"/course_id");
        passID.setValue(ID);
        DatabaseReference passGrade = dbrf.child("simpsons/students/" + Integer.toString(dbID) +"/grade");
        passGrade.setValue(grade);
        finish();

    }

}
