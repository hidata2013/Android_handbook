package com.demo.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager pageList;
    TextView textView;
    Button btn;
    SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSeekBar = findViewById(R.id.seekBar);
//        Drawable drawable = getResources().getDrawable(R.drawable.meeting_duration_thumb);
//        mSeekBar.setThumb(drawable);
        textView = findViewById(R.id.tx);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.setClass(MainActivity.this, ViewActivity.class);
                startActivity(mIntent);
            }
        });
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.q11);
        textView.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }
}
