package com.aier.ardemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.aier.ardemo.R;
import com.aier.ardemo.bean.ListItemBean;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Context context;
    List<ListItemBean> list;


    public MyAdapter(Context context, List<ListItemBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        MyHolder holder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false));
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {
        myHolder.tv.setText(list.get(i).getName());
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerViewListener.onItemClick( myHolder.itemView,i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv =  itemView.findViewById(R.id.tv);
        }
    }
    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public interface OnRecyclerViewListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
}
