package com.mynote.kano;

import android.app.Application;

import com.apollographql.apollo.ApolloClient;


import okhttp3.OkHttpClient;

public class GitConnectApplication extends Application {

  private static final String BASE_URL = "https://api.github.com/graphql";
  private ApolloClient apolloClient;


  @Override public void onCreate() {
    super.onCreate();
    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    apolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build();

  }

  public ApolloClient getApolloClient() {
    return apolloClient;
  }

}
