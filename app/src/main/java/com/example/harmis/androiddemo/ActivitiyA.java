package com.example.harmis.androiddemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ActivitiyA extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private WorkerThread wT;
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bind the handler to current thread's(UI thread) default looper
        uiHandler = new Handler(Looper.getMainLooper()) {
            // this will handle the notification gets from worker thead
            @Override
            public void handleMessage(Message msg) {
                Bundle b = msg.getData();
                Log.i(TAG, "UI receved notification: " + b.getString("key"));
                ((TextView) findViewById(R.id.tv_info)).setText(b.getString("key"));
            }
        };
        // create a seperate thread
        wT = new WorkerThread(uiHandler);
        // starts the thead
        wT.start();
        // to wait for termination of the worker thead ==> wT.join();





    }


    public class LoadWork extends AsyncTask<String,Message,String>
    {



        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    // this method is bound to the layout.xml : onClick event of a button
    public void clickTestMsg(View v) {
       /* // now the worker thred is running, we take the handler from it
        Handler workerHandler = wT.getHandlerToMsgQueue();
        // obtain a msg object from global msg pool
        Message m = workerHandler.obtainMessage();
        Bundle b = m.getData();
        b.putString("key", getDateTimeNow());
        Log.i(TAG, "sending msg to worker thread from UI");
        // and pass the msg
        workerHandler.sendMessage(m);*/



        ArrayList<Studentbean> studentbeanArrayList=new ArrayList<>();
        Studentbean studentbean1=new Studentbean("1","Test A");
        Studentbean studentbean2=new Studentbean("2","Test B");
        Studentbean studentbean3=new Studentbean("3","Test C");


        studentbeanArrayList.add(studentbean1);
        studentbeanArrayList.add(studentbean2);
        studentbeanArrayList.add(studentbean3);

        Intent  intent=new Intent(ActivitiyA.this,ActivityB.class);
        intent.putParcelableArrayListExtra("data",studentbeanArrayList);
        startActivity(intent);
    }

    // this method is bound to the layout.xml : onClick event of a button
    public void clickTestRunnable(View v) {
        Log.i(TAG, "sending background task to worker thread from UI");
        // now the worker thred is running, we take the handler from it
        Handler workerHandler = wT.getHandlerToMsgQueue();
        workerHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.i("Runnable task", "running now.....");
            }
        });
        workerHandler.post(new BgTask(uiHandler));
    }

    private String getDateTimeNow() {
        return new SimpleDateFormat("HH:mm:ss MM/dd/yyyy").format(new Date());
    }
}