package com.facebook.jingweih.tinnews.retrofit.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {

    public String status;
    public int totalResult;
    @SerializedName("articles")
    public List<News> articles;
}
