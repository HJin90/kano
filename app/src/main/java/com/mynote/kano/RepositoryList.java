package com.mynote.kano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RepositoryList extends AppCompatActivity {

    private ArrayList<Repository> rList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);

        ListView listView=(ListView)findViewById(R.id.repository_listView);

        Repository r1 = new Repository("Chie");
        Repository r2 = new Repository("Kano");

        rList.add(r1);
        rList.add(r2);

        RepositoryAdapter adapter = new RepositoryAdapter(this,rList,R.layout.activity_main);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),RepositoryClicked.class);
                intent.putExtra("name",rList.get(position).getName());
                startActivity(intent);
            }
        });


    }
}
