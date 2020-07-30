package com.zr0726.news.vo;
//这里的实体类不会进入数据库
public class NewQuery {
    private String title;

    private Long typeId;

    private boolean recommend;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "NewQuery{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommend=" + recommend +
                '}';
    }
}


