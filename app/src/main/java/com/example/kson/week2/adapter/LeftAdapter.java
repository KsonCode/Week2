package com.example.kson.week2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kson.week2.R;
import com.example.kson.week2.bean.LeftClsBean;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {

    private List<LeftClsBean.Cls> list;
    private Context context;

    public LeftAdapter(List<LeftClsBean.Cls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_item_layout,viewGroup,false);

        LeftViewHolder leftViewHolder = new LeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder leftViewHolder, final int pos) {

        final LeftClsBean.Cls cls = list.get(pos);
        leftViewHolder.nameTv.setText(cls.name);

        leftViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener!=null){
                    itemClickListener.click(cls.cid);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();//三目运算符
    }

    class LeftViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
        }
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void click(String cid);
    }
}
