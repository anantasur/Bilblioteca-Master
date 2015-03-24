package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListBooksCommandTest {
    Library library ;
    List<Book> bookList = new ArrayList<Book>();

    @Before
    public void setUp() throws Exception {
        bookList.add(new Book("Wings of Fire","A. P. J. Abdul Kalam",2004));
        bookList.add(new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle",1987));
        bookList.add(new Book("Ramayana", "Valmiki",2001));
        bookList.add(new Book("Five Point Someone", "Chetan Bhagat",2010));
        this.library = new Library(bookList);
    }
    @Test
    public void shouldListBooksWhenExecuted(){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ListBooksCommand listBooksCommand = new ListBooksCommand(ps , library);
        listBooksCommand.execute();
        assertEquals(library.toString() + System.lineSeparator(), os.toString());
    }


}
