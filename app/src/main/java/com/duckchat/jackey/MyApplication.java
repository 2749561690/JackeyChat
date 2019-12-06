package com.duckchat.jackey;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.duckchat.basecomponent.BaseApplication;
import com.duckchat.basecomponent.core.BaseFrame;
import com.duckchat.basecomponent.core.HttpFrame.config.HttpUrlConfig;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUrlConfig.init();
        BaseFrame.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //分DEX
        MultiDex.install(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        BaseFrame.stop();
    }
}
