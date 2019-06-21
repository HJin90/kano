package com.mynote.kano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.w3c.dom.Text;

import javax.annotation.Nonnull;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitConnectApplication gitConnectApplication = new GitConnectApplication();
        ApolloClient apolloClient = gitConnectApplication.getApolloClient();

        GetRepositoryQuery getRepositoryQuery
                = GetRepositoryQuery.builder()
                .loginId("MDQ6VXNlcjQ2MjcxNzkz").build();

        ApolloCall query = apolloClient
                .query(getRepositoryQuery);
        final String[] k = {null};
        query.enqueue(new ApolloCall.Callback<GetRepositoryQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetRepositoryQuery.Data> response) {
                k[0] = response.data().toString();
                Log.v("태그", k[0]);
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {
                Log.e("1", e.getMessage(), e);
            }
        });
        Log.v("태크",k[0]);
    /*  TextView mTextView = findViewById(R.id.textView20);
        mTextView.setText("Response is: "+ k[0].substring(0,500));  */
    }
}
