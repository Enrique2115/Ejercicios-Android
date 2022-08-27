package com.example.musicplayer.ui.music;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicplayer.R;

import java.io.File;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;//assigning memory loc once or else multiple songs will play at once
    int position;
    SeekBar songSeekBar;
    ArrayList<File> mySongs;
    Thread updateSeekBar;
    Button pause, next, previous;
    TextView songNameText;

    String sName;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        songNameText = (TextView) findViewById(R.id.songTextView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Now Playing");

        pause = (Button) findViewById(R.id.btnPause);

        previous = (Button) findViewById(R.id.btnPrevious);
        next = (Button) findViewById(R.id.btnNext);

        songSeekBar = (SeekBar) findViewById(R.id.seekBar);


        updateSeekBar = new Thread() {
            @Override
            public void run() {
                int totalDuration = mediaPlayer.getDuration();
                int currentPosition = 0;
                while (currentPosition < totalDuration) {
                    try {
                        sleep(500);
                        currentPosition = mediaPlayer.getCurrentPosition();
                        songSeekBar.setProgress(currentPosition);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };


        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Intent i = getIntent();
        Bundle b = i.getExtras();


        mySongs = (ArrayList) b.getParcelableArrayList("songs");

        sName = mySongs.get(position).getName().toString();

        String SongName = i.getStringExtra("songname");
        songNameText.setText(SongName);
        songNameText.setSelected(true);

        position = b.getInt("pos", 0);
        Uri u = Uri.parse(mySongs.get(position).toString());

        mediaPlayer = MediaPlayer.create(getApplicationContext(), u);
        mediaPlayer.start();
        songSeekBar.setMax(mediaPlayer.getDuration());
        updateSeekBar.start();
        songSeekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        songSeekBar.getThumb().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);


        songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i,
                                          boolean b) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songSeekBar.setMax(mediaPlayer.getDuration());
                if (mediaPlayer.isPlaying()) {
                    pause.setBackgroundResource(R.drawable.icon_play);
                    mediaPlayer.pause();

                } else {
                    pause.setBackgroundResource(R.drawable.icon_pause);
                    mediaPlayer.start();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                position = ((position + 1) % mySongs.size());
                Uri u = Uri.parse(mySongs.get(position).toString());
                // songNameText.setText(getSongName);
                mediaPlayer = MediaPlayer.create(getApplicationContext(), u);

                sName = mySongs.get(position).getName().toString();
                songNameText.setText(sName);

                try {
                    mediaPlayer.start();
                } catch (Exception e) {
                }

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //songNameText.setText(getSongName);
                mediaPlayer.stop();
                mediaPlayer.release();

                position = ((position - 1) < 0) ? (mySongs.size() - 1) : (position - 1);
                Uri u = Uri.parse(mySongs.get(position).toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), u);
                sName = mySongs.get(position).getName().toString();
                songNameText.setText(sName);
                mediaPlayer.start();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
