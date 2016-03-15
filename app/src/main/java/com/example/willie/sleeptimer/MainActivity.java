package com.example.willie.sleeptimer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    static TextView textViewTime, hourViewTime, minuteViewTime, secondViewTime;
    EditText hourText, minuteText, secondText;
    CounterClass timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing all the variables
        btnStart =(Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnEnd);
        textViewTime = (TextView)findViewById(R.id.textViewTime);
        hourViewTime = (TextView)findViewById(R.id.hoursTextView);
        minuteViewTime = (TextView)findViewById(R.id.minutesTextView);
        secondViewTime = (TextView)findViewById(R.id.secondsTextView);
        hourText = (EditText)findViewById(R.id.hours);
        minuteText = (EditText)findViewById(R.id.minutes);
        secondText = (EditText)findViewById(R.id.seconds);

        //Make timer invisible for now.
        //textViewTime.setVisibility(View.INVISIBLE);




        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hours = Integer.parseInt(hourText.getText().toString());
                int minutes = Integer.parseInt(minuteText.getText().toString());
                int seconds = Integer.parseInt(secondText.getText().toString());
                long total = (TimeUnit.HOURS.toMillis(hours) + TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS.toMillis(seconds));
                timer = new CounterClass(total, 1000);
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });
    }
}
