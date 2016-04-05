package com.example.alibaba.stmcapturerobo;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.felhr.usbserial.UsbSerialDevice;

public class MainActivity extends AppCompatActivity {

    Button button_usb;
    Button button_camera;
    ImageView tak_nie_usb;
    ImageView tak_nie_camera;
    boolean bool_usb=false;
    boolean bool_camera=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        button_camera = (Button) findViewById(R.id.button2);
        button_usb = (Button) findViewById(R.id.button);
        tak_nie_camera = (ImageView) findViewById(R.id.imageView2);
        tak_nie_usb = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        OnClinkButton();

    }


    protected void OnClinkButton() {
        button_usb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (bool_usb) {
                    bool_usb = false;
                    tak_nie_usb.setImageDrawable(getDrawable(R.drawable.no));
                } else {
                   bool_usb = true;
                    tak_nie_usb.setImageDrawable(getDrawable(R.drawable.yes));
                }
            }


        });

        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool_camera)
                {
                    bool_camera=false;
                    tak_nie_camera.setImageDrawable(getDrawable(R.drawable.no));
                }else
                {
                    bool_camera=true;
                    tak_nie_camera.setImageDrawable(getDrawable(R.drawable.yes));
                }
            }
        });
    }
}

