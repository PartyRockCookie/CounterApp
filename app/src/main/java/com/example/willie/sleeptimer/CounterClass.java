package com.example.willie.sleeptimer;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Willie Ausrotas on 3/14/2016.
 */
public class CounterClass extends CountDownTimer {
    public CounterClass(long millisInFuture, long countDownInterval){
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long millis = millisUntilFinished;
        String time = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis)
            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(millis)));

        System.out.println(time);
        MainActivity.textViewTime.setText(time);
    }

    @Override
    public void onFinish() {
        MainActivity.textViewTime.setText("Completed");
    }
}
