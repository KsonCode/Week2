package com.example.kson.week2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kson.week2.R;
import com.example.kson.week2.bean.LeftClsBean;
import com.example.kson.week2.bean.RightClsBean;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {

    private List<RightClsBean.Cls> list;
    private Context context;

    public RightAdapter(List<RightClsBean.Cls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightAdapter.RightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_item_layout,viewGroup,false);

        RightAdapter.RightViewHolder leftViewHolder = new RightAdapter.RightViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.RightViewHolder rightViewHolder, int pos) {

        RightClsBean.Cls bean = list.get(pos);

        List<RightClsBean.Cls.Pcls> list = bean.list;

        rightViewHolder.nameTv.setText(bean.name);

        //设置子分类列表适配器
        rightViewHolder.rv.setLayoutManager(new GridLayoutManager(context,3));
        rightViewHolder.rv.setAdapter(new RightItemAdapter(list,context));




    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        private RecyclerView rv;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}
