package com.mdev.msingleton.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KHUNTONGDANG on 28/7/2560.
 */

public class BusUpdateAdapter implements Parcelable{
    private boolean isUpdateAdapter;

    public BusUpdateAdapter(){}

    protected BusUpdateAdapter(Parcel in) {
        isUpdateAdapter = in.readByte() != 0;
    }

    public static final Creator<BusUpdateAdapter> CREATOR = new Creator<BusUpdateAdapter>() {
        @Override
        public BusUpdateAdapter createFromParcel(Parcel in) {
            return new BusUpdateAdapter(in);
        }

        @Override
        public BusUpdateAdapter[] newArray(int size) {
            return new BusUpdateAdapter[size];
        }
    };

    public boolean isUpdateAdapter() {
        return isUpdateAdapter;
    }

    public void setUpdateAdapter(boolean updateAdapter) {
        isUpdateAdapter = updateAdapter;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isUpdateAdapter ? 1 : 0));
    }
}
