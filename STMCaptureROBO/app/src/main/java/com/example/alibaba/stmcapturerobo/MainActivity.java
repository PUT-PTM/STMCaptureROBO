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

    Button button_usb;
    Button button_camera;
    ImageView tak_nie_usb;
    ImageView tak_nie_camera;
    ImageView przerwa_techniczna;
    boolean bool_usb = false;
    boolean bool_camera = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        button_camera = (Button) findViewById(R.id.button2);
        button_usb = (Button) findViewById(R.id.button);
        tak_nie_camera = (ImageView) findViewById(R.id.imageView2);
        tak_nie_usb = (ImageView) findViewById(R.id.imageView);
        przerwa_techniczna = (ImageView) findViewById(R.id.imageView3);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.alibaba.stmcapturerobo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
        OnClinkButton();


    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    protected void OnClinkButton()
    {
        button_usb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (bool_usb) {
                    bool_usb = false;
                    tak_nie_usb.setImageDrawable(getDrawable(R.drawable.no));
                } else {
                    bool_usb = true;
                    tak_nie_usb.setImageDrawable(getDrawable(R.drawable.yes));
                    if(bool_camera) Ready();
                }
            }
        });

        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bool_camera) {
                    bool_camera = false;
                    tak_nie_camera.setImageDrawable(getDrawable(R.drawable.no));
                } else {
                    bool_camera = true;
                    tak_nie_camera.setImageDrawable(getDrawable(R.drawable.yes));
                    if(bool_usb) Ready();
                }
            }
        });
    }
    protected  void Ready()
    {
        if(bool_usb)
            if(bool_camera)
            {
                Context context = getApplicationContext();
                Intent intent = new Intent(context,Camera_Arduino_Activity.class);
                startActivity(intent);
            }





    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.alibaba.stmcapturerobo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

