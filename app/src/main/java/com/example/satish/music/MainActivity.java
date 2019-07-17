package com.example.satish.music;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = findViewById(R.id.play);
        Button pause = findViewById(R.id.pause);
        Button stop = findViewById(R.id.stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.vachinde);
                    mediaPlayer.start();
                }else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }
                break;

            case R.id.pause:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pauseCurrentPosition = mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }

    }
}
