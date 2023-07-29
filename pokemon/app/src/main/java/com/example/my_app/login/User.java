package com.example.my_app.login;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private int age;
    private String phone;
    private String sex;
    private String photo;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(String username, String password, int age, String phone,String sex,String photo) {
        super();
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.sex = sex;
        this.photo = photo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", age=" + age + ", phone=" + phone + ", sex=" + sex + "]";
    }

}
