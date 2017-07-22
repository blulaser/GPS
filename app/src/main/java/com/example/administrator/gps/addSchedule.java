package com.example.administrator.gps;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.RemoteInput;
import android.util.Log;
import android.widget.Toast;

public class addSchedule extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "weewr", Toast.LENGTH_SHORT).show();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {


        Log.d("test", "서비스의 onDestroy");
        super.onDestroy();

    }

    private CharSequence getMessageText(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence("extra_remote_reply");
        }
        return null;
    }









}
