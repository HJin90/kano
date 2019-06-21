package com.mynote.kano;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String userId;
    public String diaryDate;
    public String dContent;

    public User(){
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String userId, String diaryDate, String dContent){
        this.userId=userId;
        this.diaryDate=diaryDate;
        this.dContent=dContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", diaryDate='" + diaryDate + '\'' +
                ", dContent='" + dContent + '\'' +
                '}';
    }
}
