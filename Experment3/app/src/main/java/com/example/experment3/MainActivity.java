package com.example.experment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_sex;
    private Button btn_sumbit;
    private CheckBox ck_basketball,ck_dance,ck_paint,ck_sing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        rg_sex = findViewById(R.id.rg_sex);
        ck_basketball = findViewById(R.id.ck_basketball);
        ck_dance = findViewById(R.id.ck_dance);
        ck_paint = findViewById(R.id.ck_paint);
        ck_sing = findViewById(R.id.ck_sing);
        btn_sumbit = findViewById(R.id.btn_sumbit);

        //注册监听器
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(MainActivity.this,"你选择的性别是："+radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });

        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.ck_basketball:
                        if(isChecked){
                            Toast.makeText(MainActivity.this, "你喜欢的是：" + ck_basketball.getText(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.ck_dance:
                        if (isChecked){
                            Toast.makeText(MainActivity.this, "你喜欢的是：" + ck_dance.getText(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.ck_paint:
                        if (isChecked){
                            Toast.makeText(MainActivity.this, "你喜欢的是：" + ck_paint.getText(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.ck_sing:
                        if (isChecked){
                            Toast.makeText(MainActivity.this, "你喜欢的是：" + ck_sing.getText(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        };

        ck_basketball.setOnCheckedChangeListener(onCheckedChangeListener);
        ck_dance.setOnCheckedChangeListener(onCheckedChangeListener);
        ck_paint.setOnCheckedChangeListener(onCheckedChangeListener);
        ck_sing.setOnCheckedChangeListener(onCheckedChangeListener);

        btn_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intern = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intern);
            }
        });

    }
}