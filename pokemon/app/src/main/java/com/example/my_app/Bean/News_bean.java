package com.example.my_app.Bean;

public class News_bean {
    private String title;
    private String subtitle;
    private String tip;
    private String pic;

    public News_bean(String title, String subtitle,String tip, String pic){
        this.title = title;
        this.subtitle = subtitle;
        this.tip = tip;
        this.pic = pic;
    }

    public News_bean(String title, String subtitle,String tip){
        this.title = title;
        this.subtitle = subtitle;
        this.tip = tip;
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
    public void setTip(String Tip) {
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

}
