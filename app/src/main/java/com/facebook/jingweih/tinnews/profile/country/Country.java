package com.facebook.jingweih.tinnews.profile.country;

import android.support.annotation.DrawableRes;

public class Country {

    private final @DrawableRes int drawableRes;
    private final String string;
    private final String dbString;
    private boolean isSelected;

    public Country(int drawableRes, String string, String dbString, boolean isSelected) {
        this.drawableRes = drawableRes;
        this.string = string;
        this.isSelected = isSelected;
        this.dbString = dbString;
    }

    public String getDbString() {
        return dbString;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public String getString() {
        return string;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
