package com.aier.ardemo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.aier.ardemo.adapter.MyAdapter;
import com.aier.ardemo.bean.ListItemBean;
import com.baidu.ar.util.ARLog;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity implements MyAdapter.OnRecyclerViewListener{

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private List<ListItemBean> mListData;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ARLog.setDebugEnable(true);
        initData();
        initView();
    }

    private void initData() {
        mListData = getListItemData();
        mAdapter = new MyAdapter(this,mListData);
    }

    private void initView() {
        recyclerView =  findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //设置Adapter
        recyclerView.setAdapter(mAdapter);
        //设置分隔线
//        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        mAdapter.setOnRecyclerViewListener(this);
    }

    private List<ListItemBean> getListItemData() {
        List<ListItemBean> list = new ArrayList<>();
        list.add(new ListItemBean("小熊",5, "10301534", ""));
        list.add(new ListItemBean("沙发",5, "10301540", ""));
        list.add(new ListItemBean("椅子",5, "10301541", ""));
        list.add(new ListItemBean("椅子02",5, "10301542", ""));
        list.add(new ListItemBean("小猫",5, "10301556", ""));
        return list;
    }

    @Override
    public void onItemClick(View view, int position) {
        intent = new Intent(ListActivity.this, ARActivity.class);
        Bundle bundle = new Bundle();
        ListItemBean listItemBean = mListData.get(position);
        bundle.putString("ar_key", listItemBean.getARKey());
        bundle.putInt("ar_type", listItemBean.getARType());
        bundle.putString("ar_path", listItemBean.getARPath());
        bundle.putString("name", listItemBean.getName());
        bundle.putString("description", listItemBean.getDescription());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

}