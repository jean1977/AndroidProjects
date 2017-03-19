package com.hfad.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private int decsecs = 0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
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
        decsecs = 0;
    }


    //Sets the number of decsecs on the timer.
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = decsecs /3600000;
                int minutes = (decsecs %3600)/60;
                int secs = decsecs %1000;
                String time = String.format("%d:%02d:%02d",   hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    decsecs++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }


}
