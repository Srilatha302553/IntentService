package com.example.serviceandintentservice.intentservice;


import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.serviceandintentservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class IntentServiceActivity extends AppCompatActivity {


    private static final String TAG = IntentServiceActivity.class.getSimpleName();


    int count = 0;

    private boolean isServiceBound;
    private ServiceConnection serviceConnection;

    /*Handler handler;*/


    private Intent serviceIntent;

    private boolean mStopLoop;
    @BindView(R.id.startButton)
    TextView startButton;
    @BindView(R.id.stopButton)
    TextView stopButton;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    String ServiceRegister = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("Intent Service ");
        setSupportActionBar(toolbar);
        Log.i(getString(R.string.service_demo_tag), "MainActivity thread id: " + Thread.currentThread().getId());

        serviceIntent = new Intent(getApplicationContext(), MyIntentService.class);


    }

    // start Service
    @OnClick(R.id.startButton)
    public void setStartButton() {
        mStopLoop = true;
        ServiceRegister = "service";
        startService(serviceIntent);
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();

    }

    // stop Service
    @OnClick(R.id.stopButton)
    public void setstopButton() {
        if (ServiceRegister == "") {
            Toast.makeText(this, "First Start a Service ", Toast.LENGTH_SHORT).show();

        } else {
            stopService(serviceIntent);
            ServiceRegister = "";
            Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        }
    }


}
