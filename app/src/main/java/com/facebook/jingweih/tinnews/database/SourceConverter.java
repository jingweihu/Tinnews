package com.facebook.jingweih.tinnews.database;

import android.arch.persistence.room.TypeConverter;

import com.facebook.jingweih.tinnews.retrofit.Response.Source;

public class SourceConverter {

    @TypeConverter
    public static String fromSourceToString(Source source) {
        return source == null ? null : source.id + "-" + source.name;
    }

    @TypeConverter
    public static Source stringToSource(String string) {
        if (string == null) {
            return null;
        } else {
            String[] source = string.split("-",   -1);
            return new Source(source[0], source[1]);
        }
    }
}
