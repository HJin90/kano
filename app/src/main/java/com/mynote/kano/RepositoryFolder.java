package com.mynote.kano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RepositoryFolder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_folder);

        Intent intent = getIntent();

        TextView name = (TextView)findViewById(R.id.tv_name);

        name.setText(intent.getStringExtra("name"));
    }
}
