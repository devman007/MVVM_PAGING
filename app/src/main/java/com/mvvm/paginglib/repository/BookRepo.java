package com.mvvm.paginglib.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvm.paginglib.model.BookModel;
import com.mvvm.paginglib.repository.apicallback.BookApiCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.mvvm.paginglib.utils.UtilsMethods.mLog;
import static com.mvvm.paginglib.utils.UtilsVariables.BASE_URL;

public class BookRepo {

    private static final String TAG = "BookRepo";
    MutableLiveData<List<BookModel>> bookMutableList;

    public Retrofit getRetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }


    public MutableLiveData<List<BookModel>> getAllBooks() {
        mLog(TAG, "jkbknk");

        bookMutableList = new MutableLiveData<>();
        BookApiCallback bookApiCallback = getRetrofitClient().create(BookApiCallback.class);

        bookApiCallback.getAllBookApiCallback("1").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mLog(TAG, "jkbknk"+response);
                bookMutableList.setValue(parseJson(response.body()));
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

        return bookMutableList;
    }

    private List<BookModel> parseJson(String json) {
        mLog(TAG, "jkbknk"+json);
        List<BookModel> bookModelList = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(json);

            JSONArray arr = obj.getJSONArray("books");
            for (int i = 0; i < arr.length(); i++) {

                JSONObject childObj = (JSONObject) arr.get(i);
                BookModel bookModel = new BookModel();
                bookModel.setTitle(childObj.getString("title"));
                bookModel.setSubtitle(childObj.getString("subtitle"));
                bookModel.setIsbn13(childObj.getString("isbn13"));
                bookModel.setPrice(childObj.getString("price"));
                bookModel.setImage(childObj.getString("image"));
                bookModel.setUrl(childObj.getString("url"));

                bookModelList.add(bookModel);
//                "title": "Full Stack JavaScript",
//                "subtitle": "Learn Backbone.js, Node.js and MongoDB",
//                "isbn13": "9781484217504",
//                "price": "$39.99",
//                "image": "https://itbook.store/img/books/9781484217504.png",
//                "url": "https://itbook.store/books/9781484217504"
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bookModelList;

    }
}
