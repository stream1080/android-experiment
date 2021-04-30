package com.example.experiment6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private String content;
    private IOMessageClick listener;

    public MyFragment() { }

    public MyFragment(String content) {
        this.content = content;
    }

    public interface IOMessageClick{
        public void onClick(String content);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOMessageClick) context;
    }


    public static MyFragment newInstance(String content,int imageId) {

        Bundle args = new Bundle();
        args.putString("content",content);
        args.putInt("imageId",imageId);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        TextView fg_tv = view.findViewById(R.id.fg_tv);
        Button fg_btn = view.findViewById(R.id.fg_btn);
        ImageView fg_iv = view.findViewById(R.id.fg_iv);

        if (getArguments() != null) {
            fg_iv.setImageResource(getArguments().getInt("imageId"));
            fg_tv.setText(getArguments().getString("content"));
        }

        fg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getArguments().getString("content"));
            }
        });
        return view;
    }
}
