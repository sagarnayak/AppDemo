package com.example.sagar.appdemo.ui.dashboard.pojo;

@SuppressWarnings("unused")
public class GridItem {
    private int icon;
    private String label;

    public GridItem() {
    }

    public GridItem(int icon, String label) {
        this.icon = icon;
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
