package com.aier.ardemo;

import android.app.Application;

import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.util.Res;

public class BaseApplication extends Application {

    private static Application appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Res.addResource(this);
        // 设置App Id
        DuMixARConfig.setAppId("16021623");
        // 设置API Key
        DuMixARConfig.setAPIKey("ZI0SDxDIWvtMnHvs2scKXC2x");
        // 设置Secret Key
        DuMixARConfig.setSecretKey("ncNvjMB2QpFm6eaU9UGjkNxnk4oPxlIk");

    }

    public static Application getAppContext() {
        return appContext;
    }
}
