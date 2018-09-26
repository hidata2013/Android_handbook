package com.demo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends FragmentActivity {

    Fragment fragmentLeft;
    Fragment fragmentRight;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_fragment_page);
        btn = findViewById(R.id.sw);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentLeft = new TitleFragment();
                fragmentRight = new ContentFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, fragmentLeft, "right").commit();
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentLeft = new TitleFragment();
        fragmentRight = new ContentFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentLeft, "left");
        // commit already called , 需要统一一起commit
        fragmentTransaction.add(R.id.container, fragmentRight, "right").commit();
//        fragmentTransaction.replace(R.id.right_pane, fragmentRight, fragmentRight.getTag()).commit();

    }

}
