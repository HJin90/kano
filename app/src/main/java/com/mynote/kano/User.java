package com.mynote.kano;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String userId;
    public String diaryDate;
    public String diaryContent;

    public User(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String userId, String diaryDate, String diaryContent){
        this.userId=userId;
        this.diaryDate=diaryDate;
        this.diaryContent=diaryContent;
    }
}
