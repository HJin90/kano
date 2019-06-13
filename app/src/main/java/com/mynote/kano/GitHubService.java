package com.mynote.kano;

import com.mynote.kano.crawling.vo.Branch;
import com.mynote.kano.crawling.vo.Commit;
import com.mynote.kano.crawling.vo.Contributors;
import com.mynote.kano.crawling.vo.Directory;
import com.mynote.kano.crawling.vo.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    //repository 받아오기
    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);

    //branch 받아오기
    @GET("repos/{user}/{repos}/branches")
    Call<List<Branch>> listBranch(@Path("user") String user, @Path("repos") String repos, @Body Branch branch);

    //contributor 받아오기
    @GET("repos/{user}/{repos}/contributors")
    Call<Contributors> listContributor(@Path("user") String user, @Path("repos") String repos, @Body Contributors contributors);

    //commit내역 가져오기
    @GET("repos/{user}/{repos}/commits")
    Call<List<Commit>> listCommit(@Path("user") String user, @Path("repos") String repos, @Body Commit commit);

    //directory 가져오기
    @GET("repos/{user}/{repos}/contents/{sha}")
    Call<List<Commit>> listDirectory(@Path("user") String user, @Path("repos") String repos, @Body Directory directory);

}