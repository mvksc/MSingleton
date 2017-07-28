package com.mdev.msingleton.manager;

import com.mdev.msingleton.model.ModelDataBall;

import java.util.List;

/**
 * Created by KHUNTONGDANG on 27/7/2560.
 */

public class IxIISingleton {
    public static IxIISingleton IxIISingleton;
    private List<ModelDataBall> dataSet;
    public static IxIISingleton getInstance(){
        if (IxIISingleton == null){
            IxIISingleton = new IxIISingleton();
        }
        return IxIISingleton;
    }
    public void setDataBall(List<ModelDataBall> listData){
        this.dataSet = listData;
    }
    public List<ModelDataBall> getDataBall(){
        return this.dataSet;
    }
    public void clear(){
        if (this.dataSet.size() > 0){
            this.dataSet.clear();
        }
        this.dataSet = null;

        if (IxIISingleton != null){
            IxIISingleton = null;
        }
    }
}
