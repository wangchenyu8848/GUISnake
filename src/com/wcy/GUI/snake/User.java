package com.wcy.GUI.snake;

public class User {
    private String name;
    private String psd;

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String name, String psd) {
        super();
        this.name = name;
        this.psd = psd;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
