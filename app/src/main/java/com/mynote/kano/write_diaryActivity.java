package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.EditText;
import android.widget.TextView;

//엉망이다아아아아 꺄아아아아아아아아아 내일은 제발 잘되었으면
public class write_diaryActivity extends AppCompatActivity {

    private EditText diaryContent;
    private String diaryDate;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        diaryDate = intent.getExtras().getString("diaryDate");
        userId = intent.getExtras().getString("userId");

        if(intent!= null) {
            TextView tx1 =findViewById(R.id.dateView);
            tx1.setText(diaryDate);
        }

    }

    private void writeNewDiary(View view){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        Intent intent = getIntent();
        diaryDate = intent.getExtras().getString("diaryDate");
        userId = intent.getExtras().getString("userId");

/*
        User user = new User(userId, diaryDate, diaryContent);
*/

        myRef.child("Users").child(userId).setValue(userId);
        myRef.child("Users").child(userId).child("diaryContent").setValue(diaryContent);
        myRef.child("Users").child(userId).child("diaryDate").setValue(diaryDate);

        Intent intent2 = new Intent(this, calendarActivity.class);
        startActivity(intent2);
        finish();
    }
}
