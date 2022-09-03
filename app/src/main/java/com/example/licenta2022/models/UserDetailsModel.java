package com.example.licenta2022.models;

public class UserDetailsModel  {
    private String name;
    private String firstname;
    private int age;

    public UserDetailsModel(String name, String firstname, int age){
        this.name=name;
        this.firstname=firstname;
        this.age=age;
    }

    public String getName(){
        return name;
    }
    public String getFirstname(){
        return firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
