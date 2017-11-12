package com.wind.writenumber;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by H on 2017/11/11.
 */

public class Music extends AppCompatActivity {
    private MediaPlayer mediaPlayer = new MediaPlayer();
    static boolean isPlay = true;

    public Music(MediaPlayer mediaPlayer, boolean isPlay) {
        this.mediaPlayer = mediaPlayer;
    }

    public void PlayMusic() {
        mediaPlayer = MediaPlayer.create(this,R.raw.main_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
}

    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void onRestart() {
        super.onRestart();
        if (isPlay == true) {
            PlayMusic();
        }
    }
}
