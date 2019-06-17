package com.mynote.kano;

import android.app.Application;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.cache.normalized.CacheKey;
import com.apollographql.apollo.cache.normalized.CacheKeyResolver;
import com.apollographql.apollo.exception.ApolloException;
import com.mynote.kano.kano.FeedQuery;
import com.mynote.kano.kano.type.FeedType;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import okhttp3.OkHttpClient;

public class GitConnectApplication extends Application {

  private static final String BASE_URL = "https://api.github.com/graphql";
  private static final String SUBSCRIPTION_BASE_URL = "wss://api.githunt.com/subscriptions";
  private ApolloClient apolloClient;


  @Override public void onCreate() {
    super.onCreate();
    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    ApolloClient apolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build();

  }

  public ApolloClient apolloClient() {
    return apolloClient;
  }

}
