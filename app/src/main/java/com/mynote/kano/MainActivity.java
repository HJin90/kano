package com.mynote.kano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitConnectApplication gitConnectApplication = new GitConnectApplication();
        ApolloClient apolloClient = gitConnectApplication.getApolloClient();
        OkHttpClient okHttpClient = gitConnectApplication.getOkHttpClient();

        if (okHttpClient != null) {
            GetRepositoryQuery getRepositoryQuery
                    = GetRepositoryQuery.builder()
                    .loginId("MDQ6VXNlcjQ2MjcxNzkz").build();

            if (apolloClient != null) {
                ApolloCall query = apolloClient
                        .query(getRepositoryQuery);

                if (query != null) {

                    query.enqueue(new ApolloCall.Callback<GetRepositoryQuery.Data>() {

                        @Override
                        public void onResponse(@Nonnull Response<GetRepositoryQuery.Data> response) {
                            String k = response.data().toString();
                                Log.v("태그", k);
                        }

                        @Override
                        public void onFailure(@Nonnull ApolloException e) {
                            Log.e("1", e.getMessage(), e);
                        }
                    });
                }
            }
        }
    }
}
