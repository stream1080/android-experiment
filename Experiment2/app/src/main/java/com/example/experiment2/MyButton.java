package com.example.experiment2;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;


import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    private static final String TAG = "MyButton";
    public MyButton(Context context) {
        super(context);
    }
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //先执行
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "onKeyDown: ");
        return super.onKeyDown(keyCode, event);
    }
    //后执行
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        String suffix = "选中";
        String text = getText().toString();
        Log.i(TAG, "onFocusChanged: ");
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

}
