package com.mynote.kano;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

   private static Response<GetRepositoryQuery.Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitConnectApplication gitConnectApplication = new GitConnectApplication();
        ApolloClient apolloClient = gitConnectApplication.getApolloClient();
        OkHttpClient okHttpClient = gitConnectApplication.getOkHttpClient();

        GetRepositoryQuery getRepositoryQuery
                = GetRepositoryQuery.builder()
                .loginId("MDQ6VXNlcjQ2MjcxNzkz").build();

        ApolloCall query = apolloClient
                .query(getRepositoryQuery);

        query.enqueue(new ApolloCall.Callback<GetRepositoryQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetRepositoryQuery.Data> response) {
                data = response;
                String k = response.data().toString();
                Log.v("태그", k);
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
                Log.e("1", e.getMessage(), e);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String k = data.data().toString();
        Log.v("태그", k);
/*
        TextView textView = findViewById(R.id.textView20);
        textView.setText(data.data().toString());
*/
    }
}
