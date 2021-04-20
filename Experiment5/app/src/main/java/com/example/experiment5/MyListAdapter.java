package com.example.experiment5;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Photo> mPhotoList;

    public MyListAdapter(Context context, List<Photo> mPhotoList) {
        mContext = context;
        this.mPhotoList = mPhotoList;
    }

    @Override
    public int getCount() {
        return mPhotoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.iv);
            viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
            viewHolder.tv_content = convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);

        }else{
            viewHolder =  (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(mPhotoList.get(position).getImageId());
        viewHolder.tv_title.setText(mPhotoList.get(position).getTitle());
        viewHolder.tv_content.setText(mPhotoList.get(position).getContent());

        return convertView;
    }


    private class ViewHolder{
        private ImageView imageView;
        private TextView tv_title,tv_content;
    }
}
