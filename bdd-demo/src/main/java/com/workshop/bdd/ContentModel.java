package com.workshop.bdd;

import java.util.Date;

public class ContentModel {
    private String id;
    private String title;
    private Integer totalChapter;
    private Integer viewStat;
    private String[] tag;
    private Date createdDate;

    public Integer getTotalChapter() {
        return totalChapter;
    }

    public void setTotalChapter(Integer totalChapter) {
        this.totalChapter = totalChapter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViewStat() {
        return viewStat;
    }

    public void setViewStat(Integer viewStat) {
        this.viewStat = viewStat;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
