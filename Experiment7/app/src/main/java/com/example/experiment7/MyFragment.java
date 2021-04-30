package com.example.experiment7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_item,container,false);
        ImageView titleIcon = view.findViewById(R.id.item_tab_iv);
        ImageView imageView = view.findViewById(R.id.item_iv);
        TextView textView = view.findViewById(R.id.item_tv);

        if (getArguments() != null) {
            Flower flower = getArguments().getParcelable("flower");
            textView.setText(flower.getTitle());
            titleIcon.setImageResource(flower.getTitleIcon());
            imageView.setImageResource(flower.getImageId());
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
