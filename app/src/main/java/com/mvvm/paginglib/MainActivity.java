package com.mvvm.paginglib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mvvm.paginglib.adapter.BookAdapter;
import com.mvvm.paginglib.databinding.ActivityMainBinding;
import com.mvvm.paginglib.model.BookModel;
import com.mvvm.paginglib.viewmodel.BookViewModel;

public class MainActivity extends AppCompatActivity implements BookAdapter.BookItemInterface {

    private ActivityMainBinding binding;
    private BookAdapter bookAdapter;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();

        bookViewModel = new BookViewModel();
        bookViewModel.getBookListMutation().observe(MainActivity.this, bookModels -> {
                bookAdapter.submitList(bookModels);
        });
    }

    private void initView() {
        binding.rvBookList.setHasFixedSize(true);
        binding.rvBookList.setLayoutManager(new LinearLayoutManager(this));

        bookAdapter = new BookAdapter(this);
        binding.rvBookList.setAdapter(bookAdapter);
    }


    @Override
    public void addBook(BookModel bookModel) {

    }

    @Override
    public void onBookItemClick(BookModel bookModel) {

    }
}