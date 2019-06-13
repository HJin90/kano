package com.mynote.kano.crawling;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mynote.kano.GitHubService;
import com.mynote.kano.R;
import com.mynote.kano.crawling.vo.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

    public class GitHub extends AppCompatActivity implements GitHubService {
        private Retrofit mRetrofit;
        private GitHubService service;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setRetrofitInit();
        }

        private void setRetrofitInit() {
            mRetrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").build();
            service = mRetrofit.create(GitHubService.class);
        }

        @Override
        public Call<List<Repository>> listRepos(String user) {
            Call<List<Repository>> repos = service.listRepos("jeongjiyoun");

            return null;
        }
    }

