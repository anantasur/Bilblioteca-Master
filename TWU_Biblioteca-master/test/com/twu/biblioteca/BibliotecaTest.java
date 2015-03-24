package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {
    Library library ;
    List<Book> bookList = new ArrayList<Book>();

    @Before
    public void setUp() throws Exception {
        bookList.add(new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle",1987));
        bookList.add(new Book("Wings of Fire","A. P. J. Abdul Kalam",2004));
        bookList.add(new Book("Ramayana", "Valmiki",2001));
        bookList.add(new Book("Five Point Someone", "Chetan Bhagat",2010));
        this.library = new Library(bookList);
    }
    @Test
    public void test_library_should_have_list_of_all_4_books() {
        assertTrue(library.isBookListSame(bookList));
    }

    @Test
    public void test_BibliotecaApp_should_display_welcome_message() {
        Biblioteca biblioteca = new Biblioteca();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        biblioteca.printWelcomeMessage(printStream);
        String expected = "Welcome to Biblioteca." + System.lineSeparator();
        assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void test_Bibleotica_App_displays_list_of_Books_with_details() {
        String expected = "Title - Author - year of publication\n-------------------------------------------\n"+
            "The Adventures of Sherlock Holmes-Arthur Conan Doyle-1987\n"+
            "Wings of Fire-A. P. J. Abdul Kalam-2004\n"+
            "Ramayana-Valmiki-2001\n"+
            "Five Point Someone-Chetan Bhagat-2010\n";
        assertEquals(new Library(bookList).toString(), expected);
    }
}
