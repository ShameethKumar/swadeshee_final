package com.example.emuapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.io.IOException;
import java.nio.charset.Charset;

public class LED extends AppCompatActivity {


    Switch led1, led2, led3, led4;
    Connection mBluetoothConnection;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);
        led1 = findViewById(R.id.led1);
        led2 = findViewById(R.id.led2);
        led3 = findViewById(R.id.led3);
        led4 = findViewById(R.id.led4);
        mBluetoothConnection = new Connection(getBaseContext());

        if(mBluetoothConnection!=null){
            System.out.println("mbluetooth connection is NULL--------------->>>");
            byte[] bytes = "1111".getBytes(Charset.defaultCharset());
//            mBluetoothConnection.write(bytes);
        }


        led1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    byte[] bytes = "1111".getBytes(Charset.defaultCharset());

                    try{
                        mBluetoothConnection.write(bytes);

                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }

                }
                else{
                    byte[] bytes = "1000".getBytes(Charset.defaultCharset());
                    mBluetoothConnection.write(bytes);
                }
            }
        });

        led2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    byte[] bytes = "2222".getBytes(Charset.defaultCharset());
//                    mBluetoothConnection.write(bytes);
                    System.out.println("led 2 is on");

                }
                else{
                    byte[] bytes = "2000".getBytes(Charset.defaultCharset());
                    mBluetoothConnection.write(bytes);
                }
            }
        });
        led3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    byte[] bytes = "3333".getBytes(Charset.defaultCharset());
                    mBluetoothConnection.write(bytes);
                }
                else{
                    byte[] bytes = "3000".getBytes(Charset.defaultCharset());
                    mBluetoothConnection.write(bytes);
                }
            }
        });
        led4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    byte[] bytes = "4444".getBytes(Charset.defaultCharset());
                    mBluetoothConnection.write(bytes);
                }
                else{
                    byte[] bytes = "4000".getBytes(Charset.defaultCharset());
                    mBluetoothConnection.write(bytes);
                }
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
