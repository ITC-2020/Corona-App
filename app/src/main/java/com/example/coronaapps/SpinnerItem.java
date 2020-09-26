package com.example.coronaapps;

public class SpinnerItem {
    private String name;
    private int img;

    SpinnerItem(String name, int img)
    {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
