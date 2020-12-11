package com.cjz.bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 绑定服务
     */
    private Button mBnBind;
    /**
     * 调用方法
     */
    private Button mBnCall;
    /**
     * 解绑服务
     */
    private Button mBnUnbind;

    MyService.MyBinder myBinder;
    Myconn myconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_bind:
                if (myconn==null){
                    myconn=new Myconn();
                }
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent,myconn,BIND_AUTO_CREATE);
                break;
            case R.id.bn_call:
                if (myBinder!=null){
                    myBinder.call();
                }
                break;
            case R.id.bn_unbind:
                if (myconn!=null){
                    unbindService(myconn);
                    myconn=null;
                    myBinder=null;
                }
                break;

        }
    }

    private void initView() {
        mBnBind = (Button) findViewById(R.id.bn_bind);
        mBnBind.setOnClickListener(this);
        mBnCall = (Button) findViewById(R.id.bn_call);
        mBnCall.setOnClickListener(this);
        mBnUnbind = (Button) findViewById(R.id.bn_unbind);
        mBnUnbind.setOnClickListener(this);
    }

    class Myconn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
