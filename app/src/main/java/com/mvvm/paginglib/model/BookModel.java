package com.mvvm.paginglib.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class BookModel {
    String title;
    String subtitle;
    String isbn13;
    String price;
    String image;
    String url;


//      "title": "Full Stack JavaScript",
//              "subtitle": "Learn Backbone.js, Node.js and MongoDB",
//              "isbn13": "9781484217504",
//              "price": "$39.99",
//              "image": "https://itbook.store/img/books/9781484217504.png",
//              "url": "https://itbook.store/books/9781484217504"


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModel bookModel = (BookModel) o;
        return getTitle().equals(bookModel.getTitle()) &&
                getSubtitle().equals(bookModel.getSubtitle()) &&
                getIsbn13().equals(bookModel.getIsbn13()) &&
                getPrice().equals(bookModel.getPrice()) &&
                getImage().equals(bookModel.getImage()) &&
                getUrl().equals(bookModel.getUrl());
    }


    public static DiffUtil.ItemCallback<BookModel> itemCallback = new DiffUtil.ItemCallback<BookModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull BookModel oldItem, @NonNull BookModel newItem) {
            return oldItem.getIsbn13().equals(newItem.getIsbn13());
        }

        @Override
        public boolean areContentsTheSame(@NonNull BookModel oldItem, @NonNull BookModel newItem) {
            return oldItem.equals(newItem);
        }
    };

}
