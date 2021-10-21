package com.sdayazilim.insgram.DataObjects;

public class Profile {

    int id;
    boolean hide;
    String name, path;

    public Profile(){
        this.id = 0;
        this.hide = false;
        this.name = "";
        this.path = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            return 1; //NonVisible
        else
            return 0; // Visible
    }

    public void setHide(boolean pHide) {
        this.hide = pHide;
    }

    public void setHide(int pHide) {
        this.hide = pHide == 1;
    }
}
