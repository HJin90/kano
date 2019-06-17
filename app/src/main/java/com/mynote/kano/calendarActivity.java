package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;


public class calendarActivity extends AppCompatActivity {

    DatePicker datePicker;  //  datePicker - 날짜를 선택하는 달력
    String pickedDate;

    public static final int REQUEST_CODE_MENU = 101;//diary에서 받는 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
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
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        //오늘 날씨를 받게해주는 것들
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        int cDay = c.get(Calendar.DAY_OF_MONTH);


        //datePick 기능 만들기
        //datePicker.init(연도, 달, 일)
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                pickedDate = year + "," + monthOfYear + "," + dayOfMonth;

            }
        });
    }

    public void goDiary(View v){
        Intent intent = new Intent();
        intent.putExtra("date","pickedDate");
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    //writeDiary에서 처리된 결과를 받는 메소드
    //처리된 결과 코드 (resultCode)가 REQUEST_CODE_MENU랑 같으면 ㄱㄱ
    //writeDiary에서 일기를 썼으면 위에 점을 찍어줌

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==REQUEST_CODE_MENU){
            switch (requestCode){
                case 101:
               /* 캘린더에 점 찍어주는거 따로 하기
               * */
                    break;
            }
        }
    }
}