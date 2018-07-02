package com.facebook.jingweih.tinnews.retrofit;

import com.facebook.jingweih.tinnews.retrofit.Response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsRequestApi {

    @GET("top-headlines")
    Observable<BaseResponse> getNewsByCountry(@Query("country") String country);

}
