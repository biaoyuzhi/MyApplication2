package com.example.wuzh.myapplication;

import android.app.Application;

import com.huawei.android.hms.agent.HMSAgent;


/**
 * application类 | application class
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HMSAgent.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        HMSAgent.destroy();
    }
}
