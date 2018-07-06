package com.facebook.jingweih.tinnews;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.jingweih.tinnews.database.AppDatabase;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class TinApplication extends Application {

    public static AppDatabase database;
    private static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tin_db").build();
        sharedPreferences = getApplicationContext().getSharedPreferences("Tin", Context.MODE_PRIVATE);
        Stetho.initializeWithDefaults(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public static AppDatabase getDataBase() {
        return database;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }


}
