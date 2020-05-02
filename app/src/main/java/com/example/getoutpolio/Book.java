package com.example.getoutpolio;

public class Book {

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
}
