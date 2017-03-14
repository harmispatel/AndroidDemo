package com.example.harmis.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {

    ArrayList<Studentbean> studentbeanArrayList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        studentbeanArrayList=getIntent().getParcelableArrayListExtra("data");

        for (int i = 0; i < studentbeanArrayList.size(); i++) {

            Studentbean studentbean=studentbeanArrayList.get(i);
            CommonMethod.printMessage("ID="+studentbean.getStudentID()+" "+"Name= "+studentbean.getStudentName());

        }


        findViewById(R.id.button_start_activityA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityB.this,ActivitiyA.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityB.this,ActivityC.class);
                startActivity(intent);
            }
        });



        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onCreate",Toast.LENGTH_LONG).show();

        CommonMethod.printMessage("ActivitiyB"+"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onStart",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyB"+"onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onRestart",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyB"+"onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onPause",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyB"+"onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onResume",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyB"+"onResume");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onStop",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyB"+"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"ActivitiyB"+"onDestroy",Toast.LENGTH_LONG).show();
        CommonMethod.printMessage("ActivitiyB"+"onDestroy");

    }
}
