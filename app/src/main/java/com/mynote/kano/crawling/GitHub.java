package com.mynote.kano.crawling;

import com.mynote.kano.GitHubService;
import com.mynote.kano.crawling.vo.Branch;
import com.mynote.kano.crawling.vo.Commit;
import com.mynote.kano.crawling.vo.Contributors;
import com.mynote.kano.crawling.vo.Directory;
import com.mynote.kano.crawling.vo.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

    public class GitHub implements GitHubService {
        private static Retrofit mRetrofit;
        private static GitHubService service;

        public GitHub(){
            setRetrofitInit();
        }

        private void setRetrofitInit() {
            mRetrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").build();
            service = mRetrofit.create(GitHubService.class);
        }

        @Override
        public Call<List<Repository>> listRepos(String user) {
            Call<List<Repository>> repos = service.listRepos(user);
            return repos;
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

