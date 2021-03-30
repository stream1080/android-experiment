package com.example.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private EditText showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        showText = findViewById(R.id.showText);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                showText.setText("点击了返回键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                showText.setText("点击了音量-");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                showText.setText("点击了音量+");
                break;
            case KeyEvent.KEYCODE_0:
                showText.setText("点击了0键");
                break;
            case KeyEvent.KEYCODE_A:
                showText.setText("点击了A键");
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

}