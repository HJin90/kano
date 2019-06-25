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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class write_diaryActivity extends AppCompatActivity {

    private EditText diaryContent;
    private String dContent;
    private String diaryDate;
    private String userId;
    private String wDiaryKey;//유저 다이어리 목록에 저장되어있는 key
    private String wContent;//이미 쓴 일기내용

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
        diaryContent = (EditText)findViewById(R.id.diaryContent);
        userId ="jihye2";

        if(intent!= null) {
            TextView tx1 =findViewById(R.id.dateView);
            tx1.setText(diaryDate);
        }
        String makeChildName = "/uesr-diarys"+userId+diaryDate+"/";
        Query query = myRef.child(makeChildName).orderByChild("Key");

        

        Button saveBtn = (Button)findViewById(R.id.saveBtn);


        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                writeDiary();
            }
        });
    }


    public void updateDiary(){
          ValueEventListener diaryListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Intent intent = getIntent();
                diaryDate = intent.getExtras().getString("diaryDate");
                //userId 바꿔주기
                /*   userId = intent.getExtras().getString("userId");*/
                userId = "jihye2";
                dContent = diaryContent.getText().toString();

                if (!TextUtils.isEmpty(dContent)){

                    String key = myRef.child("Diary").push().getKey();
                    Diary diary = new Diary(userId, diaryDate, dContent);
      /*      myRef.child("diary").child(key).setValue(diary);
            myRef.child("user-diary").child(userId).child(key).setValue(diary);
 */
                    Map<String, Object> postValues = diary.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/diarys/"+key, postValues);
                    childUpdates.put("/uesr-diarys"+userId+diaryDate+"/", postValues);
                    myRef.updateChildren(childUpdates);

                    /*                   Intent intent3 = new Intent(this, calendarActivity.class);
                    startActivity(intent3);*/

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
         };
        String thisUser = userId;
        Query sortbyThisuser = FirebaseDatabase.getInstance().getReference().child("diarys").orderByChild(thisUser);
        sortbyThisuser.addListenerForSingleValueEvent(diaryListener);
    }

    public void writeDiary(){
        Intent intent = getIntent();
        diaryDate = intent.getExtras().getString("diaryDate");
        //userId 바꿔주기
        /*   userId = intent.getExtras().getString("userId");*/
        userId = "jihye2";

        dContent = diaryContent.getText().toString();

        if (!TextUtils.isEmpty(dContent)){

            String key = myRef.child("Diary").push().getKey();
            Diary diary = new Diary(userId, diaryDate, dContent);
      /*      myRef.child("diary").child(key).setValue(diary);
            myRef.child("user-diary").child(userId).child(key).setValue(diary);
*/
            Map<String, Object> postValues = diary.toMap();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("key",key);

            childUpdates.put("/diarys/"+key, postValues);
            childUpdates.put("/uesr-diarys"+userId+diaryDate+"/", postValues);
            myRef.updateChildren(childUpdates);



            Intent intent2 = new Intent(this, calendarActivity.class);
            startActivity(intent2);

        }else{
            Toast.makeText(this,"내용입력 ㄱㄱ",Toast.LENGTH_LONG).show();
        }
    }
}




