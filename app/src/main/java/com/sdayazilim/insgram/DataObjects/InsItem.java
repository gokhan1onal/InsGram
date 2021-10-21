package com.sdayazilim.insgram.DataObjects;

public class InsItem {

    int id, pId;
    String date, url, duration, caption, thumbPath, path;
    boolean hide, isVideo;

    public InsItem(){
        this.id = 0;
        this.pId = 0;
        this.date = "";
        this.url = "";
        this.duration = "";
        this.caption = "";
        this.thumbPath = "";
        this.path = "";
        this.hide = false;
        this.isVideo = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileId() {
        return pId;
    }

    public void setProfileId(int profileId) {
        this.pId = profileId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isHide() {
        return hide;
    }

    public int getHide() {
        if(hide)
            return 1; // InVisible
        else
            return 0; // Visible
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public void setHide(int hide) {
        this.hide = hide == 1;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public int getVideo() {
        if(isVideo)
            return 1; // Video
        else
            return 0; // Image
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public void setVideo(int video) {
        isVideo = video == 1;
    }
}
