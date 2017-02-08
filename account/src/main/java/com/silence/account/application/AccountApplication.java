package com.silence.account.application;

import android.app.Application;

import com.silence.account.model.User;

import cn.bmob.v3.Bmob;

/**
 * Created by Silence on 2016/3/28 0028.
 */
public class AccountApplication extends Application {
//    private RefWatcher refWatcher;
    private static AccountApplication sAccountApplication;
    public static User sUser;

//    public static RefWatcher getRefWatcher(Context context) {
//        AccountApplication application = ( AccountApplication) context.getApplicationContext();
//        return application.refWatcher;
//    }

    public static AccountApplication getApplication() {
        return sAccountApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(getApplicationContext(), "b2e28d05deabab31c4e1bfdd24f2de6f");
        sAccountApplication = this;
//        refWatcher = LeakCanary.install(this);

    }
}
