package com.example.kson.week2.presenter;

import com.example.kson.week2.bean.LeftClsBean;
import com.example.kson.week2.bean.RightClsBean;
import com.example.kson.week2.contract.ClsContract;
import com.example.kson.week2.model.ClsModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class ClsPresennter extends ClsContract.ClsPresenter {

    private ClsModel clsModel;
    private ClsContract.IclsView view;

    public ClsPresennter( ClsContract.IclsView view) {
        this.clsModel = new ClsModel();
        this.view = view;
    }

    @Override
    public void getLeftList(HashMap<String, String> params) {

        clsModel.getLeftList(params, new ClsModel.ClsModelCallback() {
            @Override
            public void leftSuccess(String result) {

                LeftClsBean leftClsBean = new Gson().fromJson(result,LeftClsBean.class);

                List<LeftClsBean.Cls> data = leftClsBean.data;

                view.leftSucess(data);


            }

            @Override
            public void rightSUccess(String result) {

            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });



    }

    @Override
    public void getRightList(HashMap<String, String> params) {
        clsModel.getRightList(params, new ClsModel.ClsModelCallback() {
            @Override
            public void leftSuccess(String result) {

            }

            @Override
            public void rightSUccess(String result) {
                RightClsBean rightClsBean = new Gson().fromJson(result,RightClsBean.class);

                List<RightClsBean.Cls> data = rightClsBean.data;

                view.rightSucess(data);
            }

            @Override
            public void leftFailure(String error) {

            }

            @Override
            public void rightFailure(String error) {

            }
        });
    }
}
