package com.example.experiment8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String status;
    private static TextView tv_receiver;
    private CheckBox ck_consent;
    private Button btn_enter;
    private SharedPreferences sharedPreferences;
    LocalBroadcastManager localBroadcastManager;
    private MyDynamicReceiver myDynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //读取文件
//        status = sharedPreferences.getString("consent","");

        ck_consent = findViewById(R.id.ck_consent);
        btn_enter = findViewById(R.id.btn_enter);

        ck_consent.setOnCheckedChangeListener(listener);
        btn_enter.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("consent", MODE_PRIVATE);//文件名cloud，直接覆盖

//        //动态广播
        localBroadcastManager = LocalBroadcastManager.getInstance(MainActivity.this);
//
//        //动态注册
//        myDynamicReceiver = new MyDynamicReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("new dynamic");
//        localBroadcastManager.registerReceiver(myDynamicReceiver,intentFilter);
//


    }

    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                status = "True";
            }else {
                status = "False";
            }
        }
    };

    @Override
    public void onClick(View v) {
        //发送广播
        Intent intent = new Intent("new Dynamic Broad");
        intent.putExtra("consent",status);
        localBroadcastManager.sendBroadcast(intent);

        Log.i("TAG", "onClick: "+ status);

        //保存状态,写入文件
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("consent",status);
        editor.apply();//写入数据

        finish();
    }



    private static class MyDynamicReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            intent.getStringExtra("consent");
            tv_receiver.setText(intent.getStringExtra("consent"));
        }
    }

}