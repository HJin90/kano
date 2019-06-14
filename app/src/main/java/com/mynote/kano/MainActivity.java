package com.mynote.kano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mynote.kano.crawling.GitHub;
import com.mynote.kano.crawling.vo.Branch;
import com.mynote.kano.crawling.vo.Commit;
import com.mynote.kano.crawling.vo.Contributors;
import com.mynote.kano.crawling.vo.Directory;
import com.mynote.kano.crawling.vo.Repository;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitHub gitHub = new GitHub();
        gitHub.listRepos("jeongjioyoun");
    }
}
