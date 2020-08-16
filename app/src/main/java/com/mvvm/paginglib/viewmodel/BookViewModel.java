package com.mvvm.paginglib.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mvvm.paginglib.model.BookModel;
import com.mvvm.paginglib.repository.BookRepo;

import java.util.List;

public class BookViewModel extends ViewModel {

    BookRepo bookRepo;

    public BookViewModel() {
        this.bookRepo = new BookRepo();
    }

    public MutableLiveData<List<BookModel>> getBookListMutation() {
        return bookRepo.getAllBooks();
    }


}
