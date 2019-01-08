package com.liang.choosegridsinglemultirecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<JavaBean> beanList;
    LayoutInflater layoutInflater;
    private ImageView mImageView;
    private TextView mTextView;
    private int roleCode;

    public GridViewAdapter(Context context, List<JavaBean> beanList, int roleCode) {
        this.context = context;
        this.beanList = beanList;
        this.roleCode = roleCode;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return beanList.size() + 1;//注意此处;
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.grid_view_item, null);
        mImageView = (ImageView) convertView.findViewById(R.id.iv_item);
        mTextView = (TextView) convertView.findViewById(R.id.tv_content);
        if (position < beanList.size()) {
            mImageView.setBackgroundResource(beanList.get(position).getIconId());
            mTextView.setText(beanList.get(position).getContent());
        } else {
            if (roleCode == 0) {
                mImageView.setBackgroundResource(R.drawable.bt_add_pic);//最后一个显示加号图片
            } else {

            }

            mTextView.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }
}
