package com.mynote.kano.crawling;

import android.util.Log;

import com.mynote.kano.GitHubService;
import com.mynote.kano.crawling.vo.Branch;
import com.mynote.kano.crawling.vo.Commit;
import com.mynote.kano.crawling.vo.Contributors;
import com.mynote.kano.crawling.vo.Directory;
import com.mynote.kano.crawling.vo.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHub implements GitHubService {
    public static Retrofit mRetrofit;
    public static GitHubService service;

    public GitHub(){
        setRetrofitInit();
    }

    public void setRetrofitInit() {
        mRetrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
        service = mRetrofit.create(GitHubService.class);
    }

    public Call<List<Repository>> listRepos(String user) {
        service.listRepos(user).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful()) {
                    List<Repository> body = response.body();
                    if (body != null) {
                        for (Repository repo: body){
                            Log.d("repository.getId()", repo.getId() + "");
                            Log.d("repository.getName()", repo.getName() + "");
                            Log.d("Full_name()", repo.getFull_name());
                            Log.d("getDescription()", repo.getDescription());
                            Log.d("getBranch()", repo.getDefault_branch());
                            Log.e("getData end", "======================================");
                        }
                    } else{
                        Log.e("error", "body == null");
                    }
                } else{
                    Log.e("error", "response != sucess");
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                    //메인 화면으로 보낸다
            }
        });
        return null;
    }

        @Override
        public Call<List<Branch>> listBranch(String user, String repos) {
            Call<List<Branch>> listBranch = service.listBranch(user,repos);
            return listBranch;
        }

        @Override
        public Call<Contributors> listContributor(String user, String repos) {
            Call<Contributors> listContributor = service.listContributor(user,repos);
            return listContributor;
        }

        @Override
        public Call<List<Commit>> listCommit(String user, String repos) {
            Call<List<Commit>> listCommit = service.listCommit(user,repos);
            return listCommit;
        }

        @Override
        public Call<List<Directory>> listDirectory(String user, String repos) {
            Call<List<Directory>> listDirectory = service.listDirectory(user,repos);
            return listDirectory;
        }
    }

