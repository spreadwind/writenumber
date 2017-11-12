package com.wind.writenumber;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    Music music;
    static boolean isPlay = true;
//    MediaPlayer mediaPlayer = new MediaPlayer();
    MediaPlayer mediaPlayer;
    Button btn_music;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btn_music = (Button) findViewById(R.id.btn_music);
    }

    @Override
    protected void initData() {
        PlayMusic();
    }

    private void PlayMusic() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.main_music);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   /* @Override
    protected void onStop() {
        super.onStop();
        music.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        music.onDestroy();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        music.onRestart();
    }*/

    public void OnPlay(View v) {
        startActivity(new Intent(MainActivity.this, SelectActivity.class));
    }

    public void OnAbout(View v) {
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }

    /**
     * 判断音乐播放状态，如果处于播放状态，点击按钮后切换为静音状态
     * @param v
     */
    public void OnMusic(View v) {
        if (isPlay == true) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                btn_music.setBackgroundResource(R.drawable.btn_music2);
                isPlay = false;
            }
        } else {
            PlayMusic();
            btn_music.setBackgroundResource(R.drawable.btn_music1);
            isPlay = true;
        }
    }

    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    protected void onRestart() {
        super.onRestart();
        if (isPlay == true) {
            PlayMusic();
        }
    }
}
