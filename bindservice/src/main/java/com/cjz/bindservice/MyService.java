package com.cjz.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    void method(){
        Log.d("MyService", "调用服务中的method()方法");
    }

    @Override
    public void onCreate() {
        Log.d("MyService", "创建服务，调用onCreate()方法");
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("MyService", "解绑服务，调用onUnbind()方法");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService", "绑定服务，调用onBind()方法");
        return new MyBinder();
    }

    class MyBinder extends Binder{
        public void call(){
            method();
        }
    }
}
