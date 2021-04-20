package com.example.experiment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mLv;
    List<Photo> mPhoneList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        mLv = findViewById(R.id.lv);
    }

    private void initDate() {
        mPhoneList = new ArrayList<Photo>();
        mPhoneList.add(new Photo(R.mipmap.maotai,"飞天茅台","2015年53度贵州茅台"));
        mPhoneList.add(new Photo(R.mipmap.maotai,"飞天茅台","2015年53度贵州茅台"));
        mPhoneList.add(new Photo(R.mipmap.maotai,"飞天茅台","2015年53度贵州茅台"));
        mPhoneList.add(new Photo(R.mipmap.maotai,"飞天茅台","2015年53度贵州茅台"));
        mPhoneList.add(new Photo(R.mipmap.maotai,"飞天茅台","2015年53度贵州茅台"));
        mPhoneList.add(new Photo(R.mipmap.maotai,"飞天茅台","2015年53度贵州茅台"));
    }
}