package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReturnCommand implements Command{

    private Library library;
    private InputStream bookName;
    private PrintStream ps;

    public ReturnCommand(Library library, InputStream bookName, PrintStream ps) {
        this.library = library;
        this.bookName = bookName;
        this.ps = ps;
    }

    public void execute() {
        ps.println(Book.REQUEST_MESSAGE);
        Scanner scanner = new Scanner(bookName);
        if(library.checkIn(scanner.next()))
            ps.print(Library.CHECK_IN_SUCCESS + System.lineSeparator());
        else
            ps.print(Library.CHECK_IN_UN_SUCCESS + System.lineSeparator());
    }
}
