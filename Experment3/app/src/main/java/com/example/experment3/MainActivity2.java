package com.example.experment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private ImageView img_car;
    private RadioGroup bt_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //初始化
        img_car = findViewById(R.id.img_car);
        bt_car = findViewById(R.id.bt_car);

        //注册
        bt_car.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                switch(radioButton.getId()){
                    case R.id.bt_bm:
                        img_car.setImageResource(R.mipmap.bm_car);
                        break;
                    case R.id.bt_bk:
                        img_car.setImageResource(R.mipmap.bk_car);
                        break;
                    case R.id.bt_bsj:
                        img_car.setImageResource(R.mipmap.bsj_car);
                        break;
                    case R.id.bt_bc:
                        img_car.setImageResource(R.mipmap.bc_car);
                        break;
                    default:
                        break;
                }
            }
        });

    }
}