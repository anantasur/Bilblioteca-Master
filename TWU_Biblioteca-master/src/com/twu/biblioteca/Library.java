package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    static final String CHECKOUT_SUCCESS ="Thank you! Enjoy the book";
    static final String CHECKOUT_UN_SUCCESS ="That book is not available";
    static final String CHECK_IN_SUCCESS = "Thank you for returning the book.";
    static final String CHECK_IN_UN_SUCCESS = "That is not a valid book to return.";

    private List<Book> availableBookList = new ArrayList<Book>();
    private List<Book> checkedOutBooksList = new ArrayList<Book>();

    public Boolean isBookListSame(List<Book> bookList) {
        for (Book book : bookList) {
            if(!availableBookList.contains(book))
                return false;
        }
        return true;
    }

    public Library(List<Book> availableBookList) {
        this.availableBookList = availableBookList;
    }

    @Override
    public String toString() {
        String statement = Book.getHeader() +
                "-------------------------------------------\n";
        for (Book book: availableBookList)
            statement += book.toString()+"\n";
        return  statement;
    }

    private Book search(String bookName,List<Book> list){
        for (Book book : list) {
            if(book.isSame(bookName))
                return book;
        }
        return null;
    }

    public boolean checkout(String bookName) {
        Book b = search(bookName,availableBookList);
        checkedOutBooksList.add(b);
        return availableBookList.remove(b);
    }

    public boolean checkIn(String bookName) {
        Book b = search(bookName,checkedOutBooksList);
        if(b!=null) {
            availableBookList.add(b);
            return checkedOutBooksList.remove(b);
        }
        return false;
    }
}
