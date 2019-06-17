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

    apolloClient.query(
            FeedQuery.builder()
                    .limit(10)
                    .type(FeedType.HOT)
                    .build()
    ).enqueue(new ApolloCall.Callback<FeedQuery.Data>() {

      @Override public void onResponse(@NotNull Response<FeedQuery.Data> dataResponse) {

        final StringBuffer buffer = new StringBuffer();
        for (FeedQuery.Data.Feed feed : dataResponse.data().feed()) {
          buffer.append("name:" + feed.repository().fragments().repositoryFragment().name());
          buffer.append(" owner: " + feed.repository().fragments().repositoryFragment().owner().login());
          buffer.append(" postedBy: " + feed.postedBy().login());
          buffer.append("\n~~~~~~~~~~~");
          buffer.append("\n\n");
        }

        // onResponse returns on a background thread. If you want to make UI updates make sure they are done on the Main Thread.
        MainActivity.this.runOnUiThread(new Runnable() {
          @Override public void run() {
            TextView txtResponse = (TextView) findViewById(R.id.txtResponse);
            txtResponse.setText(buffer.toString());
          }
        });

      }

      @Override
      public void onFailure(@NotNull ApolloException e) {

      }

      @Override public void onFailure(@NotNull Throwable t) {
        Log.e(TAG, t.getMessage(), t);
      }
    });
  }

  public ApolloClient apolloClient() {
    return apolloClient;
  }

}
