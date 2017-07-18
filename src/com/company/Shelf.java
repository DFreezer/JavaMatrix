package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Shelf {
    /**
     * For containing books
     */
    private ArrayList<Book> shelf = new ArrayList<>();

    /**
     * @return shelf
     */
    public ArrayList<Book> getShelf() {
        return shelf;
    }
    /**
     * Add book to the shelf
     * @param book
     */
    public void addToShelf(Book book) {
        shelf.add(book);
    }

    /**
     * Search book on the shelf
     * @param book
     * @return true if shelf contain book or false if isn't
     */
    public boolean findBook(Book book) {
        return shelf.contains(book);
    }

    /**
     * @return numbers of books on the shelf
     */
    public int numbersOfBooks() {
        return shelf.size();
    }

    /**
     * Remove book from the shelf
     * @param book
     */
    public void removeFromShelf(Book book) {
        shelf.remove(book);
    }

    /**
     * Sort books by alphabet
     */
    public void sortByAlphabet() {
        if(!shelf.isEmpty()) {
            shelf.sort(Comparator.comparing(Book::getName));
        }
    }

    /**
     * print names of books in console
     */
    public void printBooks() {
        for (Book b :
                shelf) {
            System.out.println(b.getName());
        }
    }

    /**
     * Search books with given key
     * @param key
     */
    public void searchAllMatches(String key) {
        for (Book b : shelf) {
            if(b.getName().substring(0, key.length()).equalsIgnoreCase(key)) {
                System.out.println(b.getName());
            }
        }
    }

    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        Book book = new Book();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();
        book.setName("I'm robot.");
        book1.setName("Harry Potter");
        book2.setName("Game of thrones");
        book3.setName("Metro 2033");
        book4.setName("S.T.A.L.K.E.R.");
        book5.setName("Metto!");
        shelf.addToShelf(book);
        shelf.addToShelf(book1);
        shelf.addToShelf(book2);
        shelf.addToShelf(book3);
        shelf.addToShelf(book4);
        shelf.addToShelf(book5);
        shelf.sortByAlphabet();
        shelf.printBooks();
        shelf.searchAllMatches("Me");
        if(shelf.findBook(book1)) System.out.println("Book found!");
        else System.out.println("Book not found!");
        System.out.println(shelf.numbersOfBooks());
        shelf.removeFromShelf(book1);
        if(shelf.findBook(book1)) System.out.println("Book found!");
        else System.out.println("Book not found!");
    }
}
