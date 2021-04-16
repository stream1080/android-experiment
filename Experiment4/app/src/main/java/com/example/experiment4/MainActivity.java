package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_1, btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);

        OnClick onClick = new OnClick();
        btn_1.setOnClickListener(onClick);
        btn_2.setOnClickListener(onClick);

    }


    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_1:
                    customDialog();
                    break;
                case R.id.btn_2:
                    horizontalDialog();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 进度条对话框
     */
    private void horizontalDialog() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("网络加载");
        //自定义图标
        progressDialog.setIcon(R.drawable.tencent);
        progressDialog.setMessage("正在努力加载中，请耐心等待......");
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.setSecondaryProgress(20);
        progressDialog.show();

        //创建一个线程，模拟进度条
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressDialog.getProgress() < progressDialog.getMax()){
                    progressDialog.incrementProgressBy(1);
                    progressDialog.incrementSecondaryProgressBy(1);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();
    }


    /**
     * 普通对话框
     */
    private void customDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.dialogStyle);
        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_custom, null);
//        builder.setView(dialogView).create();
        final AlertDialog dialog = builder.setView(dialogView).create();

        dialog.show(); //显示

        Button btn_yes , btn_no;
        //初始化Button对象
        btn_yes = dialogView.findViewById(R.id.btn_yes);
        btn_no = dialogView.findViewById(R.id.btn_no);

        //点击事件
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        //点击事件
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}