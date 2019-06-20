package com.mynote.kano;

import android.app.Application;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GitConnectApplication extends Application {
    /*github graphQL 주소*/

    private static final String BASE_URL = "https://api.github.com/graphql";
    //this is raw auth token

    //1. 암호화가 필요한지
    //2. 프로젝트 내에 넣을 수는 없으므로, 다른 방식을 강구해보기
    private static String authHeader = "52420e39c861adba1cf436d142a821121d5dc32f";
    private static ApolloClient apolloClient;
    private static OkHttpClient okHttpClient;


    //Creating a Client
    @Override
    public void onCreate() {
        super.onCreate();

      /*
      With the installation complete and schema downloaded,
      let's create your Apollo Client.
      ApolloClient uses OkHttp under the hood for handling network requests.
      So you will need to create an instance of the OkHttpClient
      and pass it to the ApolloClient builder.
       */

        /*create an instance of the OkHttpClient*/
        okHttpClient = new OkHttpClient.Builder().addInterceptor(
/*
                  This android project Java version does not supports Lambda Expressions
                  (it needs at least java 7) : lambda expressions are not supported at language level '7'
                  so you have to use @override annotation
*/
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder().method(original.method(), original.body());
/*                      because you need an authorization to access Github GraphQL,
                      you put a data into header */
                        builder.header("User-Agent", "Android Apollo Client");
                        builder.header("Authorization", authHeader);
                        return chain.proceed(builder.build());
                    }
                }).build();
        System.out.println(okHttpClient.toString());
        if (okHttpClient != null) {
            /*pass instance of the OkHttpClient to the ApolloClient builder*/
            apolloClient = ApolloClient.builder()
                    .serverUrl(BASE_URL)
                    .okHttpClient(okHttpClient)
                    .subscriptionTransportFactory(new WebSocketSubscriptionTransport.Factory("wss://api.githunt.com/subscriptions", okHttpClient))
                    .build();
        }
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    /*getter*/
    public ApolloClient getApolloClient() {
        if (apolloClient != null) {
            System.out.println(apolloClient.toString());
        } else {
        }
        return apolloClient;

    }

}
