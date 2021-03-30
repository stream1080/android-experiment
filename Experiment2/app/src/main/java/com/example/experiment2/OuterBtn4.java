package com.example.experiment2;

import android.view.View;
import android.widget.TextView;

public class OuterBtn4 implements View.OnClickListener {
    private TextView mTx;

    public OuterBtn4(TextView textView){
        mTx = textView;
    }

    @Override
    public void onClick(View v) {
        mTx.setText("Four被点击了-外部类形式");
    }
}
