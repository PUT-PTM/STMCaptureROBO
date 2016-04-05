package com.example.alibaba.stmcapturerobo;


import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.felhr.usbserial.UsbSerialDevice;

public class USB_connection
{
    UsbDevice device;
    UsbDeviceConnection usbDeviceConnection;
    UsbSerialDevice serial = UsbSerialDevice.createUsbSerialDevice(device,usbDeviceConnection);
}
