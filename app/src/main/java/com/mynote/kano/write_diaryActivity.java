package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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
    DatabaseReference myRef = database.getReference("User");

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

        getUser();


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
    public void getUser(){
        myRef.child("User").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
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
        writeDiary();

    }
    public void writeDiary(){

        if (!TextUtils.isEmpty(dContent)){



            User user = new User(userId, diaryDate, dContent);

            myRef.child("Users").child(userId).setValue(userId);
            /*           myRef.child("Users").child(userId).push().setValue(diaryDate);*/
            myRef.child(userId).child(diaryDate).setValue(dContent);

            Intent intent2 = new Intent(this, calendarActivity.class);
            startActivity(intent2);

        }else{
            Toast.makeText(this,"내용입력 ㄱㄱ",Toast.LENGTH_LONG).show();
        }
    }


}
