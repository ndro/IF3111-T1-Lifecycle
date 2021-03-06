package com.andoroid.lifecycleactivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;

import com.andoroid.lifecycleactivity.R;

/**
 * Created by 13512081 - Hendro Triokta Brianto on 08/02/2015.
 */
public class TracerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        notify("onCreate"); // onCreate
    }

    @Override
    protected void onPause(){
        super.onPause();
        notify("onPause"); // onPause
    }

    @Override
    protected void onResume(){
        super.onResume();
        notify("onResume"); // onResume
    }

    @Override
    protected void onStop(){
        super.onStop();
        notify("onStop"); // onStop
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        notify("onDestroy"); // onDestroy
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState"); // onRestoreInstanceState
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState"); // onSaveInstanceState
    }

    private void notify(String methodName){
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
                .setContentTitle(methodName + " " + strings[strings.length - 1]).setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText(name).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }


}
