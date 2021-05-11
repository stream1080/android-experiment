package com.example.experiment8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class ProtocolActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean status;
    private CheckBox ck_consent;
    private TextView tv_deal;
    private Button btn_enter;
    private SharedPreferences sharedPreferences;
    LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);

        ck_consent = findViewById(R.id.ck_consent);
        btn_enter = findViewById(R.id.btn_enter);
        tv_deal = findViewById(R.id.tv_deal);

        ck_consent.setOnCheckedChangeListener(listener);
        btn_enter.setOnClickListener(this);
        tv_deal.setMovementMethod(ScrollingMovementMethod.getInstance());

        //读取文件
        sharedPreferences = getSharedPreferences("consent", MODE_PRIVATE);//文件名cloud，直接覆盖
        status = sharedPreferences.getBoolean("consent",false);
        if(status){
            ck_consent.setChecked(true);
        }

        //动态广播
        localBroadcastManager = LocalBroadcastManager.getInstance(ProtocolActivity.this);

    }

    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            status = isChecked;
        }
    };

    @Override
    public void onClick(View v) {
        //发送广播
        Intent intent = new Intent("Dynamic Broad");
        intent.putExtra("consent",status);
        localBroadcastManager.sendBroadcast(intent);

        //保存状态,写入文件
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("consent",status);
        editor.apply();//写入数据

        finish();//关闭页面
    }

}