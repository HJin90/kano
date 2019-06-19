package com.mynote.kano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mynote.kano.gitHubSources.gitHUBConnect.GitConnectApplication;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GitConnectApplication gitConnectApplication = new GitConnectApplication();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
