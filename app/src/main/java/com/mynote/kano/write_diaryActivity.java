package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class write_diaryActivity extends AppCompatActivity {

    private EditText diaryContent;
    private String dContent;
    private String diaryDate;
    private String userId;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Diary");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        diaryDate = intent.getExtras().getString("diaryDate");
        /*userId = intent.getExtras().getString("userId");
        */

        userId ="jihye2";

        if(intent!= null) {
            TextView tx1 =findViewById(R.id.dateView);
            tx1.setText(diaryDate);
        }
        getDiary();
        saveDiary();

/*        ValueEventListener userListner = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user.getUserId()==userId){
                    User thisUser =user;
                    if (thisUser.getDiaryDate()==diaryDate){
                        String wContent = user.getdContent();
                        TextView tx2 = findViewById(R.id.diaryContent);
                        tx2.setText(wContent);
                        if (wContent==null){
                            writeDiary();
                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };*/

        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveDiary();
            }
        });
    }
    public void getDiary(){
        myRef.child("Diary").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Diary diary = dataSnapshot.getValue(Diary.class);
                        Log.v("diary",diary.toString());
                        if(diary.getUserId()==userId){
                            Diary thisDiary =diary;
                            if (thisDiary.getDiaryDate()==diaryDate){
                                String wContent = diary.getdContent();
                                TextView tx2 = findViewById(R.id.diaryContent);
                                tx2.setText(wContent);
                                if (wContent==null){
                                    saveDiary();
                                }
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );
    }

    private void saveDiary(){
        Intent intent = getIntent();
        diaryDate = intent.getExtras().getString("diaryDate");

       //userId 바꿔주기
     /*   userId = intent.getExtras().getString("userId");*/
        userId = "jihye2";
        diaryContent = (EditText)findViewById(R.id.diaryContent);
        dContent = diaryContent.getText().toString();
        Diary diary = new Diary(userId, diaryDate, dContent);

        myRef.child("Diary").push().setValue(diary);

        if (TextUtils.isEmpty(dContent)) {
            Toast.makeText(this,"내용입력 ㄱㄱ",Toast.LENGTH_LONG).show();
        }else{
            Intent intent2 = new Intent(this, calendarActivity.class);
            startActivity(intent2);
        }
    }
/*    public void writeDiary(){

            if (!TextUtils.isEmpty(dContent)){
                Diary diary = new Diary(userId, diaryDate, dContent);

            myRef.child("Diary").push().setValue(diary);
            *//*           myRef.child("Users").child(userId).push().setValue(diaryDate);*//*
          *//*  myRef.child(userId).child("diaryDate").setValue(diaryDate);
            myRef.child(userId).child("diaryDate").child(diaryDate).setValue(dContent);
            myRef.child(userId).child("diaryDate").child(diaryDate).setValue(diaryDate);*//*

            Intent intent2 = new Intent(this, calendarActivity.class);
            startActivity(intent2);

        }else{
            Toast.makeText(this,"내용입력 ㄱㄱ",Toast.LENGTH_LONG).show();
        }
    }*/


}
