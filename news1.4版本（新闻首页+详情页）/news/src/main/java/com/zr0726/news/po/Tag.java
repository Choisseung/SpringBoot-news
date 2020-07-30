package com.zr0726.news.po;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

//标签管理
@Entity
@Table(name="t_tag")

//多对多
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long id;
    @NotBlank(message =  "标签名称不能为空")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<News> newsList = new ArrayList<>();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }




    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
