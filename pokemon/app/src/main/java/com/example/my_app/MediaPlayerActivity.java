package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MediaPlayerActivity extends AppCompatActivity {

    private VideoView video;
    private MediaController mMediaController;
    public int sig;
    private Bundle bundle;
    private TextView video_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        //接收数据
        bundle = this.getIntent().getExtras();
        video_title = findViewById(R.id.video_title);
        video_title.setText(bundle.getString("video_title"));
        String uri = bundle.getString("src");

        video = findViewById(R.id.video_player);

        mMediaController = new MediaController(this);
        video.setVideoURI(Uri.parse(uri));
        video.setVideoPath(uri);

        mMediaController.setMediaPlayer(video);
        video.setMediaController(mMediaController);
        video.start();sig = 1;


        //返回
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MediaPlayerActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("flag", 2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


}