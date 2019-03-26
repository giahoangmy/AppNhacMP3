package com.appmp3.appnhac.Activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appmp3.appnhac.Model.SongNga;
import com.appmp3.appnhac.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class PlayerActivityNgocNga extends AppCompatActivity {
    TextView txtTitle,txtTimeSong,txtTimeTotal;
    SeekBar skSong;
    ImageView imgHinh;
    ImageButton bntPrev,bntPlay,bntStop,bntNext;
    ArrayList<SongNga> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_ngoc_nga);
        AnhXa();
        AddSong();
        animation = AnimationUtils.loadAnimation(this,R.anim.cd_rotate);
        KhoiTaoMediaPlayer();
        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
        bntPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position <0){
                    position = arraySong.size() -1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                bntPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdataTimeSong();
            }
        });

        bntNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > arraySong.size() -1){
                    position = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                bntPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdataTimeSong();
            }
        });

        bntStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                bntPlay.setImageResource(R.drawable.play2);
                KhoiTaoMediaPlayer();
            }
        });
        bntPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    //nếu đang phát -> pause -> đổi hình play
                    mediaPlayer.pause();
                    bntPlay.setImageResource(R.drawable.play2);
                } else
                {
                    // nếu đang ngừng -> phát -> dổi hình pause
                    mediaPlayer.start();
                    bntPlay.setImageResource(R.drawable.pause);
                }
                SetTimeTotal();
                UpdataTimeSong();
                imgHinh.startAnimation(animation);
            }

        });
    }
    private void UpdataTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                //updata progess skSong
                skSong.setProgress(mediaPlayer.getCurrentPosition());

                //kiểm tra thời gian bài hát->nếu kết thúc -> next
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > arraySong.size() -1){
                            position = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                        bntPlay.setImageResource(R.drawable.pause);
                        SetTimeTotal();
                        UpdataTimeSong();
                    }
                });
                handler.postDelayed(this,500);
            }
        },100);
    }
    private void SetTimeTotal(){
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        //gán max của skSong = mediaPlayer.getDuration()
        skSong.setMax(mediaPlayer.getDuration());
    }
    private void KhoiTaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(PlayerActivityNgocNga.this,arraySong.get(position).getFile());
        txtTitle.setText(arraySong.get(position).getTitle());
    }
    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new SongNga("Hồng Nhan",R.raw.hongnhan));
        arraySong.add(new SongNga("Đúng người đúng thời điểm",R.raw.dungnguoidungthoidiem));
        arraySong.add(new SongNga("Không phải em đúng không",R.raw.khongphaiemdungkhong));
        arraySong.add(new SongNga("Nếu ta ngược lối",R.raw.neutanguocloi));
        arraySong.add(new SongNga("Nơi này có anh",R.raw.noinaycoanh));
        arraySong.add(new SongNga("ánh nắng của anh",R.raw.anhnangcuaanh));
        arraySong.add(new SongNga("Về đây em lo",R.raw.vedayemlo));

    }

    private void AnhXa() {
        txtTimeSong = (TextView) findViewById(R.id.textViewTimeSong);
        txtTimeTotal = (TextView) findViewById(R.id.testViewTotal);
        txtTitle = (TextView) findViewById(R.id.textviewTitle);
        skSong = (SeekBar) findViewById(R.id.seebarSong);
        bntNext = (ImageButton) findViewById(R.id.ImagaButtonNext);
        bntPlay = (ImageButton) findViewById(R.id.ImageButtonPlay);
        bntPrev = (ImageButton) findViewById(R.id.ImageButtonPrev);
        bntStop = (ImageButton) findViewById(R.id.ImageButtonStop);
        imgHinh = (ImageView) findViewById(R.id.imageViewCd);
    }
}
