package com.mdev.msingleton.manager;

import android.util.Log;
import com.mdev.msingleton.BuildConfig;

public class AllCommand {
	public String CoverStringFromServer_One(String strData){
		try {
			return  strData.substring(strData.indexOf("{"), strData.lastIndexOf("}") + 1);
		} catch (Exception e) {
			return "";
		}
	}
	public String CoverStringFromServer_Two(String strData){
		try {
			return strData.substring(strData.indexOf("["), strData.lastIndexOf("]") + 1);
		} catch (Exception e) {
			return "";
		}
	}
	public void ShowLogCat(String tag, String msg){
		if (BuildConfig.DEBUG){
			Log.e("***AllCommand***",tag + " : " + msg);
		}
	}
}
