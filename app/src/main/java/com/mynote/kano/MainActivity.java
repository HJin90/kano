package com.mynote.kano;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitConnectApplication gitConnectApplication = (GitConnectApplication) getApplication();
        ApolloClient apolloClient = gitConnectApplication.getApolloClient();
        OkHttpClient okHttpClient = gitConnectApplication.getOkHttpClient();

        if (okHttpClient != null) {
            GetRepositoryQuery getRepositoryQuery
                    = GetRepositoryQuery.builder()
                    .loginId("jeongjiyoun").build();

            if (apolloClient != null) {
                ApolloCall query = apolloClient
                        .query(getRepositoryQuery);

                if (query != null) {

                    query.enqueue(new ApolloCall.Callback<GetRepositoryQuery.Data>() {


                        @Override
                        public void onResponse(@Nonnull Response<GetRepositoryQuery.Data> response) {
                            try {
                                String k = response.data().toString();
                                TextView tv = findViewById(R.id.textView20);
                                tv.setText(k);

                            } catch (Exception e) {
                                Log.e("1", e.getMessage(), e);

                            }
                        }

                        @Override
                        public void onFailure(@Nonnull ApolloException e) {
                            Log.e("1", e.getMessage(), e);
                        }
                    });
                } else {
                    TextView tv = findViewById(R.id.textView20);
                    tv.setText("query is null");
                }
            } else {
                TextView tv = findViewById(R.id.textView20);
                tv.setText("apollo is null");
            }
        } else {
            TextView tv = findViewById(R.id.textView20);
            tv.setText("ok is null");
        }
    }
}
