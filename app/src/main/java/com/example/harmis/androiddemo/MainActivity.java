package com.example.harmis.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this,BackgroundService.class));
        MyMethod(getApplicationContext());
    }

    public void MyMethod(@NonNull Context pContext) {
        //noinspection ConstantConditions
        if (pContext == null) {
            throw new IllegalArgumentException();
        }

    }
}
