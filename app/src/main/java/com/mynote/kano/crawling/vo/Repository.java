package com.mynote.kano.crawling.vo;

public class Repository {
    private String id; //repository Id
    private String name; //repository name
    private String full_name; //repository full_name
    private Owner owner; //owner information
    private String description; //project설명
    private String default_branch; //기본 브런치

    public Repository() {
    }

    public Repository(String id, String name, String full_name, Owner owner, String description, String default_branch) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.owner = owner;
        this.description = description;
        this.default_branch = default_branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", owner=" + owner +
                ", description='" + description + '\'' +
                ", default_branch='" + default_branch + '\'' +
                '}';
    }
}
