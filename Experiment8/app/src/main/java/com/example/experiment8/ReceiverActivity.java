package com.example.experiment8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiverActivity extends AppCompatActivity {

    private static TextView tv_receiver;
    private Button btn_deal;
    private MyDynamicReceiver myDynamicReceiver;
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        btn_deal = findViewById(R.id.btn_deal);
        tv_receiver = findViewById(R.id.tv_receiver);

        localBroadcastManager = LocalBroadcastManager.getInstance(ReceiverActivity.this);

        myDynamicReceiver = new MyDynamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("new Dynamic Broad");

        localBroadcastManager.registerReceiver(myDynamicReceiver,intentFilter);

        btn_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceiverActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private static class MyDynamicReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            tv_receiver.setText(intent.getStringExtra("consent"));
        }
    }
}