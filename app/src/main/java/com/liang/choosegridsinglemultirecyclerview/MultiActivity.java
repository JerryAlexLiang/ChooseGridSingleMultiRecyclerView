package com.liang.choosegridsinglemultirecyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultiActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TextView mTvCount;
//    private List<String> datas;
//    private List<String> selectDatas = new ArrayList<>();

    ///////////////////////////////

    private List<JavaBean> beanList;
    private List<JavaBean> selectBeanList = new ArrayList<>();

    private MultiAdapter mAdapter;


    public static void actionStart(Context context, int requestCode) {
        Intent intent = new Intent(context, MultiActivity.class);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mTvCount = (TextView) findViewById(R.id.tv_count);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mAdapter = new MultiAdapter(datas);
        mAdapter = new MultiAdapter(beanList);
        mRecyclerView.setAdapter(mAdapter);

//        mAdapter.setOnItemClickLitener(new OnItemClickLitener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                if (!mAdapter.isSelected.get(position)) {
//                    mAdapter.isSelected.put(position, true); // 修改map的值保存状态
//                    mAdapter.notifyItemChanged(position);
//                    selectDatas.add(datas.get(position));
//
//                } else {
//                    mAdapter.isSelected.put(position, false); // 修改map的值保存状态
//                    mAdapter.notifyItemChanged(position);
//                    selectDatas.remove(datas.get(position));
//                }
//                mTvCount.setText("已选中" + selectDatas.size() + "项" + selectDatas.toString());
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });

        mAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if (!mAdapter.isSelected.get(position)) {
                    mAdapter.isSelected.put(position, true); // 修改map的值保存状态
                    mAdapter.notifyItemChanged(position);
                    selectBeanList.add(beanList.get(position));

                } else {
                    mAdapter.isSelected.put(position, false); // 修改map的值保存状态
                    mAdapter.notifyItemChanged(position);
                    selectBeanList.remove(beanList.get(position));
                }
                mTvCount.setText("已选中" + selectBeanList.size() + "项" + selectBeanList.toString());
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    /**
     * 全选
     *
     * @param view
     */
//    public void all(View view) {
//        selectDatas.clear();
//
//        for (int i = 0; i < datas.size(); i++) {
//            mAdapter.isSelected.put(i, true);
//            selectDatas.add(datas.get(i));
//        }
//        mAdapter.notifyDataSetChanged();
//        mTvCount.setText("已选中" + selectDatas.size() + "项" + selectDatas.toString());
//    }
    public void all(View view) {
        selectBeanList.clear();

        for (int i = 0; i < beanList.size(); i++) {
            mAdapter.isSelected.put(i, true);
            selectBeanList.add(beanList.get(i));
        }
        mAdapter.notifyDataSetChanged();
        mTvCount.setText("已选中" + selectBeanList.size() + "项" + selectBeanList.toString());
    }

    /**
     * 反选
     *
     * @param view
     */
//    public void inverse(View view) {
//        for (int i = 0; i < datas.size(); i++) {
//            if (mAdapter.isSelected.get(i)) {
//                mAdapter.isSelected.put(i, false);
//                selectDatas.remove(datas.get(i));
//            } else {
//                mAdapter.isSelected.put(i, true);
//                selectDatas.add(datas.get(i));
//            }
//        }
//        mAdapter.notifyDataSetChanged();
//        mTvCount.setText("已选中" + selectDatas.size() + "项" + selectDatas.toString());
//
//    }
    public void inverse(View view) {
        for (int i = 0; i < beanList.size(); i++) {
            if (mAdapter.isSelected.get(i)) {
                mAdapter.isSelected.put(i, false);
                selectBeanList.remove(beanList.get(i));
            } else {
                mAdapter.isSelected.put(i, true);
                selectBeanList.add(beanList.get(i));
            }
        }
        mAdapter.notifyDataSetChanged();
        mTvCount.setText("已选中" + selectBeanList.size() + "项" + selectBeanList.toString());

    }

    /**
     * 取消已选
     *
     * @param view
     */
//    public void cancel(View view) {
//        for (int i = 0; i < datas.size(); i++) {
//            if (mAdapter.isSelected.get(i)) {
//                mAdapter.isSelected.put(i, false);
//                selectDatas.remove(datas.get(i));
//            }
//        }
//        mAdapter.notifyDataSetChanged();
//        mTvCount.setText("已选中" + selectDatas.size() + "项" + selectDatas.toString());
//    }
    public void cancel(View view) {
        for (int i = 0; i < beanList.size(); i++) {
            if (mAdapter.isSelected.get(i)) {
                mAdapter.isSelected.put(i, false);
                selectBeanList.remove(beanList.get(i));
            }
        }
        mAdapter.notifyDataSetChanged();
        mTvCount.setText("已选中" + selectBeanList.size() + "项" + selectBeanList.toString());
    }

    /**
     * 完成
     */
    public void finish(View view) {
        Intent intent = new Intent();
        //通过intent对象返回结果，必须要调用一个setResult方法
        //setResult(resultCode, data);第一个参数表示结果返回码，一般只要大于1就可以
        intent.putExtra("selectBeanList", (Serializable) selectBeanList);
        setResult(2019, intent);
        //结束当前的activity的生命周期
        finish();
    }

    private void initData() {
//        datas = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            datas.add("测试" + i);
//        }

        beanList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            beanList.add(new JavaBean(i, R.mipmap.ic_launcher, "第" + i + "个"));
        }
    }
}
