package com.liang.choosegridsinglemultirecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private List<JavaBean> beanList;
    private GridView gridView;
    private GridViewAdapter adapter;
    private int roleCode;
    private int contentIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (GridView) findViewById(R.id.gv_test);
        initDatas();
        adapter = new GridViewAdapter(GridActivity.this, beanList, roleCode);
        gridView.setAdapter(adapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (roleCode == 0) {
//                    if (position == parent.getChildCount() - 1) {
//                        beanList.add(new JavaBean(1, R.mipmap.ic_launcher, "第" + contentIndex + "个"));
//                        contentIndex++;
//                        Toast.makeText(GridActivity.this, "您点击了添加", Toast.LENGTH_SHORT).show();
//                        adapter = new GridViewAdapter(GridActivity.this, beanList, roleCode);
//                        gridView.setAdapter(adapter);
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        //其他item
//                        Toast.makeText(GridActivity.this, "你点击了" + beanList.get(position) + "个Item", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    //不可点击
//                }
//            }
//        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (roleCode == 0) {
                    if (position == parent.getChildCount() - 1) {
                        Toast.makeText(GridActivity.this, "您点击了添加", Toast.LENGTH_SHORT).show();
                        MultiActivity.actionStart(GridActivity.this, 2018);
                    } else {
                        //其他item
                        Toast.makeText(GridActivity.this, "你点击了" + beanList.get(position) + "个Item", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //不可点击
                }
            }
        });
    }

    private void initDatas() {
        beanList = new ArrayList<>();
        JavaBean javaBean = new JavaBean();
        javaBean.setId(0);
        javaBean.setIconId(R.mipmap.ic_launcher);
        javaBean.setContent("我是标兵");
        beanList.add(javaBean);
        roleCode = 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2019) {
            if (requestCode == 2018) {
                assert data != null;
                List<JavaBean> selectBeanList = (List<JavaBean>) data.getSerializableExtra("selectBeanList");
                for (int i = 0; i < selectBeanList.size(); i++) {
                    beanList.add(selectBeanList.get(i));
                    adapter = new GridViewAdapter(GridActivity.this, beanList, roleCode);
                    gridView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}
