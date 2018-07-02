package com.facebook.jingweih.tinnews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.facebook.jingweih.tinnews.retrofit.Response.News;

@Database(entities = {News.class}, version = 1)
@TypeConverters({SourceConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}