package com.example.getoutpolio;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String Title;
    private String Category;
    private String Descripton;
    private int Thembail;

    public Book() {
    }

    public Book(String title, String category, String descripton, int thembail) {
        Title = title;
        Category = category;
        Descripton = descripton;
        Thembail = thembail;
    }

    protected Book(Parcel in) {
        Title = in.readString();
        Category = in.readString();
        Descripton = in.readString();
        Thembail = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescripton() {
        return Descripton;
    }

    public int getThembail() {
        return Thembail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescripton(String descripton) {
        Descripton = descripton;
    }

    public void setThembail(int thembail) {
        Thembail = thembail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Category);
        dest.writeString(Descripton);
        dest.writeInt(Thembail);
    }
}
