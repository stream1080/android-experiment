package com.example.experiment5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mLv;
    List<Photo> mPhotoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        mLv = findViewById(R.id.lv);

        mLv.setAdapter(new MyListAdapter(MainActivity.this,mPhotoList));
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,mPhotoList.get(position).getContent(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initDate() {
        mPhotoList = new ArrayList<Photo>();
        mPhotoList.add(new Photo(R.mipmap.maotai,"贵州茅台","53度飞天茅台"));
        mPhotoList.add(new Photo(R.mipmap.wly,"五粮液","四川宜宾五粮液"));
        mPhotoList.add(new Photo(R.mipmap.lzlj,"泸州老窖","老窖特曲1573"));
        mPhotoList.add(new Photo(R.mipmap.gjgj,"古井贡酒","安徽古井贡酒"));
        mPhotoList.add(new Photo(R.mipmap.sxfj,"山西汾酒","清香型蓝汾"));
        mPhotoList.add(new Photo(R.mipmap.hzl,"海之蓝","洋河海之蓝"));
        mPhotoList.add(new Photo(R.mipmap.jgj,"酒鬼酒","酒鬼喝酒鬼"));
    }
}