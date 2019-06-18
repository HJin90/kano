package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class write_diaryActivity extends AppCompatActivity {

    String file;   //  fileName - 돌고 도는 선택된 날짜의 파일 이름
    String diaryDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        if(intent != null) {
            String date = intent.getExtras().getString("diaryDate");
            TextView tx1 =findViewById(R.id.dateView);
            tx1.setText(date);
        }
    }

}
