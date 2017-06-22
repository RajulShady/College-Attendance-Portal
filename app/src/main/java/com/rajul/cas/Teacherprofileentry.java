package com.rajul.cas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.R.attr.value;

/**
 * Created by RAJUL on 6/20/2017.
 */

   public class Teacherprofileentry extends AppCompatActivity {
    Spinner sem, branch, sec, sub;

    @Override
         protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_teacherprofileentry);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        branch = (Spinner) findViewById(R.id.adddetailsSpinnerbr);
        sem = (Spinner) findViewById(R.id.adddetailsSpinnerSem);
        sec = (Spinner) findViewById(R.id.adddetailsSpinnersec);
        sub = (Spinner) findViewById(R.id.adddetailsSpinnersub);
       }

    public void jumpToTeacherDashboard(View v){
        ParseObject ob = new ParseObject("Teacher_sub");
        ob.put("id", ParseUser.getCurrentUser().getUsername());
        ob.put("subject", sub.getSelectedItem().toString());
        ob.put("branch", branch.getSelectedItem().toString());
        ob.put("section", sec.getSelectedItem().toString());
        ob.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(getApplicationContext(), HomeTeacher.class);
                    startActivity(intent);
                } else
                    e.printStackTrace();
            }
        });


    }
    public void jumpToTeacherProfileEntry(View v){

        ParseObject ob = new ParseObject("Teacher_sub");
        ob.put("id", ParseUser.getCurrentUser().getUsername());
        ob.put("subject", sub.getSelectedItem().toString());
        ob.put("branch", branch.getSelectedItem().toString());
        ob.put("section", sec.getSelectedItem().toString());
        ob.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(getApplicationContext(), Teacherprofileentry.class);
                    startActivity(intent);
                }
            }
        });



    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}