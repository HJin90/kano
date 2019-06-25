package com.mynote.kano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Nonnull;

public class WhenGetCommitList extends AppCompatActivity {

    public String dataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        //데이터를 가져오는 방법
        WhenGetCommitList.NewThread newThread = new WhenGetCommitList.NewThread();
        newThread.setDaemon(true);

        //6월이라고 가정하면,
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss.SSSZ", Locale.getDefault());
        Date month_end = new Date();
        Date month_start = new Date();

        try {
           month_end = simpleDateFormat.parse("2019-06-30T23:59:59.000+0900");
            month_end = simpleDateFormat.parse("2019-06-01T00:00:00.000+0900");

        }catch (ParseException e){
            //ignore
            Log.e("E",e.toString(),e);
        }
        newThread.run("CSMS","jeongjiyoun","master",month_end, month_start);

        synchronized (newThread) {
            try {
                newThread.wait(3000);
            } catch (Exception e) {
                Log.e("error", e.toString(), e);
            } finally {
                //text 세팅하는 방법 - 예시
                TextView textView = findViewById(R.id.textView20);
                textView.setText(dataString);
            }
        }
    }

    //CommitList
    class NewThread extends Thread {
        public void run(String branch_name,String owner_name, String repository_name, Date month_end, Date month_start) {

            GitConnectApplication gitConnectApplication = new GitConnectApplication();
            ApolloClient apolloClient = gitConnectApplication.getApolloClient();

            GetCommitQuery getCommitQuery
                    = GetCommitQuery.builder()
                    .branch_name(branch_name)
                    .repository_name(repository_name)
                    .owner_name(owner_name)
                    .month_end(month_end)
                    .month_start(month_start)
                    .build();

            //loginId를 여기에 넣으시면 됩니다.
            apolloClient.query(getCommitQuery).enqueue(new ApolloCall.Callback<GetCommitQuery.Data>() {
                @Override
                public void onResponse(@Nonnull Response<GetCommitQuery.Data> response) {
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
