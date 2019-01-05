package com.example.kson.week2.model;

import com.example.kson.week2.api.ClsApi;
import com.example.kson.week2.contract.ClsContract;
import com.example.kson.week2.net.OkhttpCallback;
import com.example.kson.week2.net.OkhttpUtils;

import java.util.HashMap;

public class ClsModel implements ClsContract.IClsModel {


    @Override
    public void getLeftList(HashMap<String, String> params, final ClsModelCallback clsModelCallback) {
        OkhttpUtils.getInstance().doPost(ClsApi.LEFT_URL, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                if (clsModelCallback!=null)
                clsModelCallback.leftFailure(msg);
            }

            @Override
            public void success(String result) {

                if (clsModelCallback!=null){
                    clsModelCallback.leftSuccess(result);
                }

            }
        });
    }

    @Override
    public void getRightList(HashMap<String, String> params, final ClsModelCallback clsModelCallback) {
        OkhttpUtils.getInstance().doPost(ClsApi.RIGHT_URL, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                if (clsModelCallback!=null)
                    clsModelCallback.rightSUccess(msg);
            }

            @Override
            public void success(String result) {

                if (clsModelCallback!=null){
                    clsModelCallback.rightSUccess(result);
                }

            }
        });
    }

    public interface ClsModelCallback{
        void leftSuccess(String result);
        void rightSUccess(String result);
        void leftFailure(String error);
        void rightFailure(String error);
    }
}
