package com.mdev.msingleton.manager;

import com.mdev.msingleton.model.ModelDataBall;
import java.util.List;

/**
 * Created by KHUNTONGDANG on 27/7/2560.
 */

public class FTSingleton {
    public static FTSingleton FTSingleton;
    private List<ModelDataBall> dataSet;
    public static FTSingleton getInstance(){
        if (FTSingleton == null){
            FTSingleton = new FTSingleton();
        }
        return FTSingleton;
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

        if (FTSingleton != null){
            FTSingleton = null;
        }
    }
}
