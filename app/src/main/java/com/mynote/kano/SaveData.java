package com.mynote.kano;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SaveData extends AppCompatActivity {
    private static GetRepositoryQuery.Data data;
    private static String name;
    private TextView textView = findViewById(R.id.textView20);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GetRepositoryQuery.Data getData() {
        return data;
    }

    public void setData(GetRepositoryQuery.Data data) {
        this.data = data;
        Log.v("?",data.toString());
        textView.setText(data.toString());
    }
}
