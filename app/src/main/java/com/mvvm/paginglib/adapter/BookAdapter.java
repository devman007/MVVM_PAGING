package com.mvvm.paginglib.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm.paginglib.databinding.BookItemBinding;
import com.mvvm.paginglib.model.BookModel;

import java.util.List;

public class BookAdapter extends ListAdapter<BookModel, BookAdapter.BookViewHolder> {
    private final BookItemInterface bookItemInterface;

    public BookAdapter(BookItemInterface bookItemInterface) {
        super(BookModel.itemCallback);
        this.bookItemInterface=bookItemInterface;
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BookItemBinding bookItemBinding = BookItemBinding.inflate(layoutInflater, parent, false);
        return new BookViewHolder(bookItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {

        BookModel bookModel = getItem(position);
        holder.bookItemBinding.setBookModel(bookModel);
        holder.bookItemBinding.executePendingBindings();
    }


    public class BookViewHolder extends RecyclerView.ViewHolder {
        private final BookItemBinding bookItemBinding;

        public BookViewHolder(@NonNull BookItemBinding bookItemBinding) {
            super(bookItemBinding.getRoot());

            this.bookItemBinding = bookItemBinding;
        }
    }


    public interface BookItemInterface{
        void addBook(BookModel bookModel);
        void onBookItemClick(BookModel bookModel);
    }
}
