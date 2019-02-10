package com.example.reggie.gpa_georgesr1_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //final View layout = findViewById(R.id.gpa);
        //final Button submit = (Button) findViewById(R.id.SubClear);

    }

    //called when user clicks Compute GPA
    public void Compute(View View){

        final View layout = findViewById(R.id.gpa);
        final Button submit = (Button) findViewById(R.id.SubClear);

        final EditText course1 = (EditText) findViewById(R.id.courseOne);
        final EditText course2 = (EditText) findViewById(R.id.courseTwo);
        final EditText course3 = (EditText) findViewById(R.id.courseThree);
        final EditText course4 = (EditText) findViewById(R.id.courseFour);
        final EditText course5 = (EditText) findViewById(R.id.courseFive);

        final TextView gpa = (TextView) findViewById(R.id.GPA);

        /*int c1 = Integer.parseInt(course1.getText().toString());
        int c2 = Integer.parseInt(course2.getText().toString());
        int c3 = Integer.parseInt(course3.getText().toString());
        int c4 = Integer.parseInt(course4.getText().toString());
        int c5 = Integer.parseInt(course5.getText().toString());*/

        int avg = 0;

        if (course1.getText().toString().length() !=0 && course2.getText().toString().length() != 0 && course3.getText().toString().length() != 0 &&
                course4.getText().toString().length() != 0 && course5.getText().toString().length() != 0){
            avg = (Integer.parseInt(course1.getText().toString()) + Integer.parseInt(course2.getText().toString()) + Integer.parseInt(course3.getText().toString()) +
            Integer.parseInt(course4.getText().toString()) + Integer.parseInt(course5.getText().toString())) / 5;
        }else{
            Toast.makeText(MainActivity.this, "All fields must be submitted.", Toast.LENGTH_SHORT).show();
        }

        //boolean wasClicked = false;

            if (avg <= 60) {
                layout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
            } else if (avg > 60 && avg <= 80) {
                layout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.yellow));
            } else if (avg > 80) {
                layout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            }


            gpa.setText(Integer.toString(avg));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Intent j = new Intent(MainActivity.this, MainActivity.class);
        startActivity(j);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.action_clearAll:
                onRestart();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
