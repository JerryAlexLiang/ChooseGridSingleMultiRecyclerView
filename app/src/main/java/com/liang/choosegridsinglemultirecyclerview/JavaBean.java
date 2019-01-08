package com.liang.choosegridsinglemultirecyclerview;

import java.io.Serializable;

public class JavaBean implements Serializable{

    private int id;
    private Integer iconId;
    private String content;

    public JavaBean() {
    }

    public JavaBean(int id, Integer iconId, String content) {
        this.id = id;
        this.iconId = iconId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "id=" + id +
                ", iconId=" + iconId +
                ", content='" + content + '\'' +
                '}';
    }
}
