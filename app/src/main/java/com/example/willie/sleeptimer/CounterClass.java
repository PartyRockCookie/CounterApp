package com.example.willie.sleeptimer;

import android.content.Context;
import android.media.AudioManager;
import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Willie Ausrotas on 3/14/2016.
 */


public class CounterClass extends CountDownTimer {
    Context context;

    public CounterClass(long millisInFuture, long countDownInterval, Context context){
        super(millisInFuture, countDownInterval);
        this.context = context;
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
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        for(int i = 0;i<10;i++){
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.ADJUST_MUTE);
        }
        MainActivity.textViewTime.setTextSize(20);
        MainActivity.textViewTime.setText("Goodnight! Sound is now off.");
        MainActivity.showViews();
    }

}
