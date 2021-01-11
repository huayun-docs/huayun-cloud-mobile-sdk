package com.chinac.testchinacsdk;

import android.app.Application;

import com.chinac.chinacsdk.ChinacSDK;

/**
 * @author Bless
 * @date 2020/12/11
 **/
public class MyApplication extends Application {

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        init();
    }

    public static MyApplication getInstance() {
        return application;
    }

    private void init(){
        ChinacSDK.getInstance().initSDK(application);
    }
}
