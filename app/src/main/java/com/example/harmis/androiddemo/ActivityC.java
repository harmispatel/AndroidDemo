package com.example.harmis.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);


        findViewById(R.id.button_start_activityA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityC.this,ActivitiyA.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityC.this,ActivityB.class);
                startActivity(intent);
            }
        });

        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onCreate",Toast.LENGTH_LONG).show();

        CommonMethod.printMessage("ActivitiyC"+"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onStart",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyC"+"onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onRestart",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyC"+"onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onPause",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyC"+"onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onResume",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyC"+"onResume");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onStop",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyC"+"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"ActivitiyC"+"onDestroy",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyC"+"onDestroy");

    }
}
