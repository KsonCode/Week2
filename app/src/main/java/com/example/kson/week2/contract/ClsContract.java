package com.example.kson.week2.contract;

import com.example.kson.week2.bean.LeftClsBean;
import com.example.kson.week2.bean.RightClsBean;
import com.example.kson.week2.model.ClsModel;

import java.util.HashMap;
import java.util.List;

public interface ClsContract {

    abstract class ClsPresenter{

        public abstract void getLeftList(HashMap<String,String> params);
        public abstract void getRightList(HashMap<String,String> params);

    }
    public interface IClsModel{

       void getLeftList(HashMap<String,String> params, ClsModel.ClsModelCallback clsModelCallback);
       void getRightList(HashMap<String,String> params, ClsModel.ClsModelCallback clsModelCallback);



    }

    public interface IclsView{

        void leftSucess(List<LeftClsBean.Cls> leftClsBeanList);
        void rightSucess(List<RightClsBean.Cls> rightClsBeanList);
        void leftFailure(String error);
        void rightFailure(String error);


    }
}
