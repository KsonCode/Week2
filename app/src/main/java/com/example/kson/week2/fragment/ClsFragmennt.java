package com.example.kson.week2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kson.week2.R;
import com.example.kson.week2.adapter.LeftAdapter;
import com.example.kson.week2.adapter.RightAdapter;
import com.example.kson.week2.bean.LeftClsBean;
import com.example.kson.week2.bean.RightClsBean;
import com.example.kson.week2.contract.ClsContract;
import com.example.kson.week2.presenter.ClsPresennter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClsFragmennt extends Fragment implements ClsContract.IclsView ,LeftAdapter.ItemClickListener {

    private ClsPresennter clsPresennter;
    private LeftAdapter leftAdapter;
    @BindView(R.id.rv_left)
    RecyclerView leftRv;
    @BindView(R.id.rv_right)
    RecyclerView rightRv;

    private String cid = "1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cls_layout, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();


    }

    private void initData() {
        leftRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        clsPresennter = new ClsPresennter(this);

        getLeft();

        clsPresennter.getLeftList(new HashMap<String, String>());

    }

    public void getLeft(){
        HashMap<String, String> p2 = new HashMap<>();
        p2.put("cid", cid);
        clsPresennter.getRightList(p2);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void leftSucess(List<LeftClsBean.Cls> leftClsBeanList) {


        if (leftAdapter==null){
            leftAdapter = new LeftAdapter(leftClsBeanList,getActivity());
            leftRv.setAdapter(leftAdapter);
            leftAdapter.setItemClickListener(this);
        }else{
            leftAdapter.notifyDataSetChanged();
        }


    }

    @Override
    public void rightSucess(List<RightClsBean.Cls> rightClsBeanList) {
        rightRv.setAdapter(new RightAdapter(rightClsBeanList,getActivity()));
    }

    @Override
    public void leftFailure(String error) {

    }

    @Override
    public void rightFailure(String error) {

    }

    /**
     * left点击
     * @param cid
     */
    @Override
    public void click(String cid) {

        getLeft();

    }
}
