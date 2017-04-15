package com.example.hunglay.countdowntimer;

import android.media.MediaPlayer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView show;
    //CountDownT timer;
    CountDownTimer timer1;
    EditText editTimer;
    Button startB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB = (Button)findViewById(R.id.button);
        show = (TextView)findViewById(R.id.textView);
        editTimer = (EditText)findViewById(R.id.inputTime);

        startB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int time = Integer.parseInt(editTimer.getText().toString())*1000;

                        timer1 = new CountDownTimer(time,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                millisUntilFinished = millisUntilFinished/1000;
                                show.setText("seconds remaining: " + String.format("%02d:%02d:%02d", millisUntilFinished / 3600,
                                        (millisUntilFinished % 3600) / 60, (millisUntilFinished % 60)));
                            }

                            @Override
                            public void onFinish() {
                                show.setText("done!");
                                playSound();
                            }
                        }.start();
                    }
                }
        );

    }

    public void playSound() {

        MediaPlayer mp = MediaPlayer.create(getBaseContext(), (R.raw.android));
        mp.start();
    }

    public void start(View view){
        timer1.start();
    }

    public void stop(View view){
        timer1.cancel();
    }

}
