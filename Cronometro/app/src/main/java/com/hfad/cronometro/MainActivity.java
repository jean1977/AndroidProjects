package com.hfad.cronometro;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean running = false;
    boolean wasRunning;
    int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds",seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning",running);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClickStart(View view)
    {
        running = true;
    }

    public void onClickStop(View view)
    {
        running = false;
    }

    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView view = (TextView) findViewById(R.id.secs);
                view.setText(String.valueOf(seconds));
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running  =false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(wasRunning)
            running = true;
        else
            running = false;
    }
}

