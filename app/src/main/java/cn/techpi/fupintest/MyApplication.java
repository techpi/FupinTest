package cn.techpi.fupintest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Lenovo on 2016/12/14.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
