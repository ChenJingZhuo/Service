package com.cjz.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 开启服务
     */
    private Button mBnStart;
    /**
     * 关闭服务
     */
    private Button mBnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBnStart = (Button) findViewById(R.id.bn_start);
        mBnStart.setOnClickListener(this);
        mBnStop = (Button) findViewById(R.id.bn_stop);
        mBnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bn_start:
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
                break;
            case R.id.bn_stop:
                Intent intent2 = new Intent(MainActivity.this, MyService.class);
                stopService(intent2);
                break;
        }
    }
}
