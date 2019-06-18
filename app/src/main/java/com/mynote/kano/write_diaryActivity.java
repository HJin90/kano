package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.TextView;


public class write_diaryActivity extends AppCompatActivity {

    String diaryContent;   //  fileName - 돌고 도는 선택된 날짜의 파일 이름
    String diaryDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        if(intent != null) {
            diaryDate = intent.getExtras().getString("diaryDate");
            TextView tx1 =findViewById(R.id.dateView);
            tx1.setText(diaryDate);
        }



      /* myRef.setValue(diaryContent.getText().toString());*/
    }

    private void writeNewDiary(String userId, String diaryDate, String diaryContent){
        User usersDiary = new User(userId, diaryDate, diaryContent);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("users").child(userId).child("");
    }
}
