package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
//        btn_yes = findViewById(R.id.btn_yes);
//        btn_no = findViewById(R.id.btn_no);

        OnClick onClick = new OnClick();
        btn_1.setOnClickListener(onClick);
        btn_2.setOnClickListener(onClick);
//        btn_yes.setOnClickListener(onClick);
//        btn_no.setOnClickListener(onClick);


    }


    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_1:
                    customDialog();
                    break;
                case R.id.btn_2:
                    //
                    break;
                default:
                    break;
            }
        }
    }


    private void customDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_custom, null);
        builder.setView(dialogView).show();
        final AlertDialog dialog = builder.create();

        Button btn_yes , btn_no;

        btn_yes = dialogView.findViewById(R.id.btn_yes);
        btn_no = dialogView.findViewById(R.id.btn_no);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                //Log.i("TAG", "onClick: yes");
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "onClick: "+ "退出");
                builder.setView(dialogView).create().dismiss();
               // dialog.dismiss();
            }
        });

    }
}