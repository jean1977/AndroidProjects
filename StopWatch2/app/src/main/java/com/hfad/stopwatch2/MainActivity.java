package com.hfad.stopwatch2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean running = false;
    int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tempo = (TextView) findViewById(R.id.textView_tempo);
        tempo.setText(String.valueOf(seconds));
        run();
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

    private void run()
    {
        final TextView tempo = (TextView) findViewById(R.id.textView_tempo);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running) {
                    seconds++;
               }
                tempo.setText(String.valueOf(seconds));
                handler.postDelayed(this,1000);
            }
        });


    }
}
