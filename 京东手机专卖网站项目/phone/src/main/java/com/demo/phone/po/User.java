package com.demo.phone.po;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_user")
public class User {

    @Id //主键标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String imgUrl;
    private String phone;
    //是否是管理员 1 是 0否
    private boolean admin;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", admin=" + admin +
                '}';
    }
}
