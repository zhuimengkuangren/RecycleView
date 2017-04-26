package com.zhuimeng.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StaggeredActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> data;
    private StaggeredAdapter staggeredAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        initData();

        staggeredAdapter = new StaggeredAdapter(this,data);
        recyclerView.setAdapter(staggeredAdapter);
        //设置RecyclerView的布局管理
//        LinearLayoutManager linearLayoutManager = new
//                LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL));

        staggeredAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                staggeredAdapter.deleteData(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        //设置RecycleerView的item分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void initData() {
        data = new ArrayList<String>();
        for (int i = 'A'; i < 'a'; i++) {
            data.add("" + (char)i);
        }
    }

}

