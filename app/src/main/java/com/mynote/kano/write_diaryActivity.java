package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = new Intent();
        processIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent != null){
            Bundle bundle= intent.getExtras();
            diaryDate date22 = bundle.getParcelable("diaryDate");
            if (intent != null){
                /*textView.setTtext
                TextView.setText(date22.diaryDate);
            */
            }
        }
    }


}
