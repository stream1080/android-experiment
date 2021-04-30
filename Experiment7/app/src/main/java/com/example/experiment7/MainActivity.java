package com.example.experiment7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabs;
    private ViewPager mVp;
    private List<Flower> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabs = findViewById(R.id.tab_id);
        mVp = findViewById(R.id.vp);

        //加载数据
        initData();

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),0,mList);
        mVp.setAdapter(myPagerAdapter);
        mTabs.setupWithViewPager(mVp);

        setTabView();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add(new Flower("亚龙湾",R.mipmap.ylwtab,R.mipmap.ylw));
        mList.add(new Flower("呀诺达",R.mipmap.yndtab,R.mipmap.ynd));
        mList.add(new Flower("南山寺",R.mipmap.nsstab,R.mipmap.nss));
        mList.add(new Flower("凤凰岛",R.mipmap.fwdtab,R.mipmap.fwd));
    }


    private void setTabView() {
        for (int i = 0; i < mList.size(); i++) {
            TabLayout.Tab tab = mTabs.getTabAt(i);
            tab.setCustomView(R.layout.tab_item);
            View view = tab.getCustomView();
            ImageView titleIcon = view.findViewById(R.id.item_tab_iv);
            ImageView imageView = view.findViewById(R.id.item_iv);
            TextView textView = view.findViewById(R.id.item_tv);

            titleIcon.setImageResource(mList.get(i).getTitleIcon());
            imageView.setImageResource(mList.get(i).getImageId());
            textView.setText(mList.get(i).getTitle());
        }

    }

}