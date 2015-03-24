package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckOutCommandTest {
    List<Book> bookList = new ArrayList<Book>();
    Library library ;

    @Before
    public void setUp() throws Exception {
        bookList.add(new Book("Wings of Fire","A. P. J. Abdul Kalam",2004));
        bookList.add(new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle",1987));
        bookList.add(new Book("Ramayana", "Valmiki",2001));
        bookList.add(new Book("Five Point Someone", "Chetan Bhagat",2010));
        this.library = new Library(bookList);
    }
    @Test
    public void testCheckOutShouldGiveSuccessMessageOnSuccessFulCheckOut() throws Exception {
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(os);
        new CheckOutCommand(library,in,ps).execute();
        assertEquals(Book.REQUEST_MESSAGE+System.lineSeparator()+Library.CHECKOUT_SUCCESS + System.lineSeparator(),os.toString());
    }
    @Test
    public void testCheckOutShouldGiveMessageOnUnSuccessFullCheckout() throws Exception {
        InputStream in = new ByteArrayInputStream("mahabharta".getBytes());
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(os);
        new CheckOutCommand(library,in,ps).execute();
        assertEquals(Book.REQUEST_MESSAGE+System.lineSeparator()+Library.CHECKOUT_UN_SUCCESS +System.lineSeparator(),os.toString());
    }
}
