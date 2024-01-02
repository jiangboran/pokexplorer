package com.example.my_app.Bean;

public class News_bean {
    private String title;
    private String subtitle;
    private String tip;
    private String pic;
    private String content;

    public News_bean(String title, String subtitle, String tip, String pic, String content) {
        this.title = title;
        this.subtitle = subtitle;
        this.tip = tip;
        this.pic = pic;
        this.content = content;
    }

    public News_bean(String title, String subtitle, String tip, String content) {
        this.title = title;
        this.subtitle = subtitle;
        this.tip = tip;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
