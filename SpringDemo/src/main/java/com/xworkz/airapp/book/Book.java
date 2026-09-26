package com.xworkz.airapp.book;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private String title;
    private String author;
    private double price;

    public void applyDiscount(double discount) {
        price -= discount;
        System.out.println("New price: " + price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
