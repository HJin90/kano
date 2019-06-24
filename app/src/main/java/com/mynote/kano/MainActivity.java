package com.mynote.kano;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;


public class MainActivity extends AppCompatActivity {

    public String dataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터를 가져오는 방법
        NewThread newThread = new NewThread();
        newThread.setDaemon(true);
        newThread.run("MDQ6VXNlcjQ2MjcxNzkz");
        synchronized (newThread) {
            try {
                newThread.wait(3000);
            } catch (Exception e) {
                Log.e("error", e.toString(), e);
            } finally {
                Log.v("태그?", dataString);
                //text 세팅하는 방법 - 예시
                TextView textView = findViewById(R.id.textView20);
                textView.setText(dataString);
            }
        }

    }

    //데이터 가져오는 메소드
    class NewThread extends Thread {
        public void run(String userId) {

            GitConnectApplication gitConnectApplication = new GitConnectApplication();
            ApolloClient apolloClient = gitConnectApplication.getApolloClient();

            /*
            스레드 사용하는 방법!
             */

            Message msg = Message.obtain();

            GetRepositoryQuery getRepositoryQuery
                    = GetRepositoryQuery.builder()
                    .loginId(userId).build();
            //loginId를 여기에 넣으시면 됩니다.
            apolloClient.query(getRepositoryQuery).enqueue(new ApolloCall.Callback<GetRepositoryQuery.Data>() {
                @Override
                public void onResponse(@Nonnull Response<GetRepositoryQuery.Data> response) {
                    //데이터를 가져오는 식
                    String k = response.data().toString();
                    dataString = k;
                    return;
                }

                @Override
                public void onFailure(@Nonnull ApolloException e) {
                    Log.e("1", e.getMessage(), e);
                }
            });
        }
    }
}
