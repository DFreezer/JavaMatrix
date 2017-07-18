package com.company;

/*
 Книга.
 Кол-во страниц, разделы кол-во. Автор, название. переплет. ISBN. цена. Издание.m
 Полка.
 Хранить книги. Поиск по полям. Кол-во на полке. Удаление книг.
 По желанию: показать первые 10(либо указанное кол-во) книг название которых начинаются на указанные символы(грубо говоря поиск). Хранение книг в алфавитном порядке.

 */

public class Book {
    private String name;
    private String author;
    private int pageCount;
    private int sections;
    private String isbn;
    private String cover;
    private String edition;
    private double yearEdition;
    private double price;

    public Book() {}

    public Book(String name, String author, int pageCount, int sections, String isbn, String cover, String edition, double yearEdition, double price) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.sections = sections;
        this.isbn = isbn;
        this.cover = cover;
        this.edition = edition;
        this.yearEdition = yearEdition;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getYear() { return yearEdition; }

    public void setYearEdition(double yearEdition) { this.yearEdition = yearEdition; }
}