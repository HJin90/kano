package com.mynote.kano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GitConnectApplication gitConnectApplication = new GitConnectApplication();
        GetCommitQuery getCommitQuery
                = GetCommitQuery.builder()
                .owner_name("jeongjiyoun")
                .oid_id("")
                .repository_name("CSMS")
                .build();
        Log.println(0,"to",getCommitQuery.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
