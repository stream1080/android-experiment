package com.example.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2,btn3,btn4,btn5;
    private TextView showText;
    private OuterBtn4 outerBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //初始化组件
        showText = findViewById(R.id.text);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);

        //1.Activity本身作为事件监听器
        btn1.setOnClickListener(this);

        //4.外部类形式
        outerBtn4 = new OuterBtn4(showText);
        btn4.setOnClickListener(outerBtn4);

        //2.匿名内部类形式
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showText.setText("Two被点击了-匿名内部类");
            }
        });
        //3.内部类形式
        btn3.setOnClickListener(new ClickListener());
    }

    //3.内部类形式
    class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            showText.setText("Three被点击了-内部类");
        }
    }

    //1.Activity本身作为事件监听器
    @Override
    public void onClick(View v) {
        showText.setText("One被点击了-Activity本身");
    }
    //5.绑定标签
    public void btn5(View v){
        showText.setText("Five被点击了-绑定标签");
    }
}