package com.facebook.jingweih.tinnews.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.List;

import io.reactivex.Flowable;


@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();

    @Delete
    void delete(News news);

    @Query("DELETE FROM news")
    void deleteAllNews();
}
