package com.facebook.jingweih.tinnews;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.facebook.jingweih.tinnews.database.AppDatabase;
import com.facebook.stetho.Stetho;

public class TinApplication extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tin_db").build();
        Stetho.initializeWithDefaults(this);
    }

    public static AppDatabase getDataBase() {
        return database;
    }


}
