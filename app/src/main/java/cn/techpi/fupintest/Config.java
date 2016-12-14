package cn.techpi.fupintest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Lenovo on 2016/12/14.
 */

public class Config {
    public static String getConfig(String config){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(MyApplication.getAppContext());
        return  preferences.getString(config,"");
    }
}
