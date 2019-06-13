package com.mynote.kano;

import com.mynote.kano.crawling.vo.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);

    @POST("users/new")
    Call<Repository> listRepos(@Body Repository repository);

}