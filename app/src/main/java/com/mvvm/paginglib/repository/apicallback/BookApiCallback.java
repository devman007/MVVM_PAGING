package com.mvvm.paginglib.repository.apicallback;

import androidx.lifecycle.MutableLiveData;

import com.mvvm.paginglib.model.BookModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookApiCallback {

    @GET("/1.0/search/mongodb/{pageno}")
    Call<String> getAllBookApiCallback(@Path("pageno") String pageno);
}
