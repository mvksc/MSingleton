package com.mdev.msingleton.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KHUNTONGDANG on 27/7/2560.
 */

public class ModelDataTang implements Parcelable{
    private String No,TypeTang,BillID,ADD,playStep;
    private int positionTang;

    public ModelDataTang(){}
    protected ModelDataTang(Parcel in) {
        No = in.readString();
        TypeTang = in.readString();
        BillID = in.readString();
        ADD = in.readString();
        playStep = in.readString();
        positionTang = in.readInt();
    }

    public static final Creator<ModelDataTang> CREATOR = new Creator<ModelDataTang>() {
        @Override
        public ModelDataTang createFromParcel(Parcel in) {
            return new ModelDataTang(in);
        }

        @Override
        public ModelDataTang[] newArray(int size) {
            return new ModelDataTang[size];
        }
    };

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getTypeTang() {
        return TypeTang;
    }

    public void setTypeTang(String typeTang) {
        TypeTang = typeTang;
    }

    public String getBillID() {
        return BillID;
    }

    public void setBillID(String billID) {
        BillID = billID;
    }

    public String getADD() {
        return ADD;
    }

    public void setADD(String ADD) {
        this.ADD = ADD;
    }

    public String getPlayStep() {
        return playStep;
    }

    public void setPlayStep(String playStep) {
        this.playStep = playStep;
    }

    public int getPositionTang() {
        return positionTang;
    }

    public void setPositionTang(int positionTang) {
        this.positionTang = positionTang;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(No);
        dest.writeString(TypeTang);
        dest.writeString(BillID);
        dest.writeString(ADD);
        dest.writeString(playStep);
        dest.writeInt(positionTang);
    }
}
