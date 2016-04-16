package com.example.alibaba.stmcapturerobo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.felhr.usbserial.UsbSerialDevice;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button start;
    Button about;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.start);
        about = (Button)findViewById(R.id.about_aplication);
        exit = (Button)findViewById(R.id.exit);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        OnClickButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onStop() {
        super.onStop();
    }


    protected void OnClickButton()
    {
        if (null != start) {
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkConnection()) {
                        Toast.makeText(getApplicationContext(), "Connection ON", Toast.LENGTH_LONG).show();
                        Intent intent;
                        intent = new Intent(getApplicationContext(), StartActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Connection OFF", Toast.LENGTH_LONG).show();
                        Intent intent;
                        intent = new Intent(getApplicationContext(), StartActivity.class);
                        startActivity(intent);

                    }

                }
            });
        }


        if (null != about) about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


            }
        });

        if (null != exit) exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    protected  boolean checkConnection()
    {
        boolean result = false;
        StartActivity startActivity = new StartActivity();
        if(startActivity.check_connection_bool) result=true;
        return result;

    }
}



