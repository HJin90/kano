package com.mynote.kano;

import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

public class GetQuery {

    public GetQuery(){
        GitConnectApplication gitConnectApplication = new GitConnectApplication();
        ApolloClient apolloClient = gitConnectApplication.getApolloClient();
        GetRepositoryQuery getRepositoryQuery
                = GetRepositoryQuery.builder()
                .loginId("MDQ6VXNlcjQ2MjcxNzkz").build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            apolloClient.query(getRepositoryQuery).enqueue(new ApolloCall.Callback<GetRepositoryQuery.Data>() {
                @Override
                public void onResponse(@Nonnull Response<GetRepositoryQuery.Data> response) {
                    if (response.hasErrors()){
                        SaveData saveData = new SaveData();
                        saveData.setData(response.data());
                        saveData.setName("error");
                    }
                    String k = response.data().toString();
                    Log.v("태그", k);
                    SaveData saveData = new SaveData();
                    saveData.setData(response.data());
                    saveData.setName("repository");
                }

                @Override
                public void onFailure(@Nonnull ApolloException e) {
                    Log.e("1", e.getMessage(), e);
                }
            });

        }
    }
}
