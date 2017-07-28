package com.mdev.msingleton.manager;

import android.content.Context;

import com.mdev.msingleton.model.ModelDataBall;

import java.util.List;

/**
 * Created by KHUNTONGDANG on 27/7/2560.
 */

public class HTSingleton {
    public static HTSingleton HTSingleton;
    private List<ModelDataBall> dataSet;
    private Context context;
    public static HTSingleton getInstance(){
        if (HTSingleton == null){
            HTSingleton = new HTSingleton();
        }
        return HTSingleton;
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

        if (HTSingleton != null){
            HTSingleton = null;
        }
    }
}
