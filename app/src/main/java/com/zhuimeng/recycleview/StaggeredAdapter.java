package com.zhuimeng.recycleview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 追梦 on 2017/4/25.
 **/
//RecyclerView.Adapter<StaggeredAdapter.MyViewHolder>
public class StaggeredAdapter extends SimpleAdapter {

    private List<Integer> mHeight;

    public StaggeredAdapter(Context context, List<String> data) {
        super(context, data);

        mHeight = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            mHeight.add((int) (100 + Math.random() * 400));
        }
    }

    @Override
    public StaggeredAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_single_textview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(StaggeredAdapter.MyViewHolder holder, int position) {
        //动态高度设置
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeight.get(position);
        holder.itemView.setLayoutParams(lp);

        setUpItemEvent(holder);

        holder.tv.setText(data.get(position));
    }
}
