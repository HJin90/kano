package com.mynote.kano.crawling.vo;

class Owner {
    private String login; //git Url에 들어가는 이름
    private String id; //git이 부여하는 고유 id
    private String avatar_url; //프로필사진 url

    public Owner() {
    }

    public Owner(String login, String id, String avatar_url) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }

}
