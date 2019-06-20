package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class write_diaryActivity extends AppCompatActivity {

    private EditText diaryContent;
    private String dContent;
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
        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveDiary();
            }
        });
    }

    private void saveDiary(){
        Intent intent = getIntent();
        diaryDate = intent.getExtras().getString("diaryDate");
       //userId 바꿔주기
     /*   userId = intent.getExtras().getString("userId");*/
        userId = "jihye";
        diaryContent = (EditText)findViewById(R.id.diaryContent);
        dContent = diaryContent.getText().toString();

        if (!TextUtils.isEmpty(dContent)){
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("User");

            User user = new User(userId, diaryDate, dContent);

            myRef.child("Users").child(userId).setValue(userId);
            myRef.child("Users").child(userId).child("diaryDate").push().setValue(diaryDate);
            myRef.child("Users").child(userId).child("diaryDate").child("diaryContent").push().setValue(dContent);

            Intent intent2 = new Intent(this, calendarActivity.class);
            startActivity(intent2);

        }else{
            Toast.makeText(this,"내용입력 ㄱㄱ",Toast.LENGTH_LONG).show();
        }

    }


}
