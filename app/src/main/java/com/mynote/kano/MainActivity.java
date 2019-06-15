package com.mynote.kano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button goDatepickbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/
        goDatepickbutton =(Button)findViewById(R.id.goDatepickbutton);
        btn_intent.setOnClickListener(this);
    }
    에이몰라!!! 축구보러 갈거야 아아아아아아 안드로이드나쁜놈 ㅠ
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("name",txt_main.getText().toString());
        startActivity(intent);
        finish();
    }


}
