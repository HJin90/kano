package com.mynote.kano.gitHubSources.gitHUBConnect;

import android.app.Application;

import com.apollographql.apollo.ApolloClient;

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

  private ApolloClient apolloClient;

  @Override public void onCreate() {
    super.onCreate();

    //Creating a Client

      /*
      With the installation complete and schema downloaded,
      let's create your Apollo Client.
      In most cases, you’ll want to create a single shared instance of ApolloClient
      and point it at your GraphQL server.
      ApolloClient uses OkHttp under the hood for handling network requests.
      So you will need to create an instance of the OkHttpClient
      and pass it to the ApolloClient builder.
       */

      /*create an instance of the OkHttpClient*/
      OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(

                  /*This android project Java version does not supports Lambda Expressions
                  (it needs at least java 7) : lambda expressions are not supported at language level '7'
                  so you have to use @override annotation*/

              new Interceptor() {
                  @Override
                  public Response intercept(Chain chain) throws IOException {
                      Request original = chain.request();
                      Request.Builder builder = original.newBuilder().method(original.method(), original.body());
                      /*because you need an authorization to access Github GraphQL,
                      you put a data into header */
                      builder.header("Authorization", authHeader);
                      return chain.proceed(builder.build());
                  }
              }).build();

      /*pass instance of the OkHttpClient to the ApolloClient builder*/
              apolloClient = ApolloClient.builder()
                    .serverUrl(BASE_URL)
                    .okHttpClient(okHttpClient)
                    .build();
  }

  /*getter*/
  public ApolloClient getApolloClient() {
    return apolloClient;
  }

}