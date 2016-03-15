package com.example.willie.sleeptimer;

import android.content.Context;
import android.media.AudioManager;
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
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    static TextView textViewTime;
    static EditText hourText, minuteText, secondText;
    static ImageView arrowUpHour, arrowUpMinute, arrowUpSecond, arrowDownHour, arrowDownMinute, arrowDownSecond;
    CounterClass timer;
    Context c;


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
        hourText = (EditText)findViewById(R.id.hours);
        minuteText = (EditText)findViewById(R.id.minutes);
        secondText = (EditText)findViewById(R.id.seconds);
        arrowUpHour = (ImageView)findViewById(R.id.arrowUpHour);
        arrowDownHour = (ImageView)findViewById(R.id.arrowDownHour);
        arrowUpMinute = (ImageView)findViewById(R.id.arrowUpMinute);
        arrowDownMinute = (ImageView)findViewById(R.id.arrowDownMinute);
        arrowUpSecond = (ImageView)findViewById(R.id.arrowUpSecond);
        arrowDownSecond = (ImageView)findViewById(R.id.arrowDownSecond);
        c = this;



        //Make timer invisible for now.
        textViewTime.setVisibility(View.INVISIBLE);

        //Set angle for the arrows
        arrowUpHour.setRotation(-90);
        arrowUpMinute.setRotation(-90);
        arrowUpSecond.setRotation(-90);
        arrowDownHour.setRotation(90);
        arrowDownMinute.setRotation(90);
        arrowDownSecond.setRotation(90);

        //Make the EditTexts not editable manually.
        hourText.setKeyListener(null);
        minuteText.setKeyListener(null);
        secondText.setKeyListener(null);


        arrowUpHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = Integer.parseInt(hourText.getText().toString());
                hour++;
                if (hour < 10) {
                    hourText.setText("0" + hour, TextView.BufferType.EDITABLE);
                } else {
                    hourText.setText(hour, TextView.BufferType.EDITABLE);
                }
            }
        });
        arrowUpMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minute = Integer.parseInt(minuteText.getText().toString());
                minute++;
                if (minute < 10) {
                    minuteText.setText("0" + minute, TextView.BufferType.EDITABLE);
                } else {
                    minuteText.setText(minute, TextView.BufferType.EDITABLE);
                }
            }
        });
        arrowUpSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int second = Integer.parseInt(secondText.getText().toString());
                second++;
                if (second < 10) {
                    secondText.setText("0" + second, TextView.BufferType.EDITABLE);
                } else {
                    secondText.setText(second, TextView.BufferType.EDITABLE);
                }
            }
        });
        arrowDownHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = Integer.parseInt(hourText.getText().toString());
                if (hour > 0 && hour <= 10) {
                    hour--;
                    hourText.setText("0" + hour, TextView.BufferType.EDITABLE);
                } else if(hour >0 && hour > 10) {
                    hour--;
                    hourText.setText(hour, TextView.BufferType.EDITABLE);
                }
            }
        });
        arrowDownMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minute = Integer.parseInt(minuteText.getText().toString());
                if (minute > 0 && minute <= 10) {
                    minute--;
                    minuteText.setText("0" + minute, TextView.BufferType.EDITABLE);
                } else if(minute >0 && minute > 10) {
                    minute--;
                    minuteText.setText(minute, TextView.BufferType.EDITABLE);
                }
            }
        });
        arrowDownSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int second = Integer.parseInt(secondText.getText().toString());
                if (second > 0 && second <= 10) {
                    second--;
                    secondText.setText("0" + second, TextView.BufferType.EDITABLE);
                } else if(second >0 && second > 10) {
                    second--;
                    secondText.setText(second, TextView.BufferType.EDITABLE);
                }
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hours = Integer.parseInt(hourText.getText().toString());
                int minutes = Integer.parseInt(minuteText.getText().toString());
                int seconds = Integer.parseInt(secondText.getText().toString());
                long total = (TimeUnit.HOURS.toMillis(hours) + TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS.toMillis(seconds));
                timer = new CounterClass(total, 1000, c);
                textViewTime.setTextSize(50);
                textViewTime.setVisibility(View.VISIBLE);
                hideViews();
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

    private void hideViews(){
        hourText.setVisibility(View.INVISIBLE);
        minuteText.setVisibility(View.INVISIBLE);
        secondText.setVisibility(View.INVISIBLE);
        arrowUpHour.setVisibility(View.INVISIBLE);
        arrowUpMinute.setVisibility(View.INVISIBLE);
        arrowUpSecond.setVisibility(View.INVISIBLE);
        arrowDownHour.setVisibility(View.INVISIBLE);
        arrowDownMinute.setVisibility(View.INVISIBLE);
        arrowDownSecond.setVisibility(View.INVISIBLE);
    }

    public static void showViews(){
        hourText.setVisibility(View.VISIBLE);
        minuteText.setVisibility(View.VISIBLE);
        secondText.setVisibility(View.VISIBLE);
        arrowUpHour.setVisibility(View.VISIBLE);
        arrowUpMinute.setVisibility(View.VISIBLE);
        arrowUpSecond.setVisibility(View.VISIBLE);
        arrowDownHour.setVisibility(View.VISIBLE);
        arrowDownMinute.setVisibility(View.VISIBLE);
        arrowDownSecond.setVisibility(View.VISIBLE);
    }


}
