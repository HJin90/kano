package com.mynote.kano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RepositoryList extends AppCompatActivity {

    private ArrayList<ItemName> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        ListView listView=(ListView)findViewById(R.id.repository_listView);

        ItemName r1 = new ItemName("Project1");
        ItemName r2 = new ItemName("Project2");

        data.add(r1);
        data.add(r2);

        RepositoryAdapter adapter = new RepositoryAdapter(this,R.layout.repository_item,data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),RepositoryFolder.class);
                intent.putExtra("name",data.get(position).getName());
                startActivity(intent);
            }
        });
    }
}
