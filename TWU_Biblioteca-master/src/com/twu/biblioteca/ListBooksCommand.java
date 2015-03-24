package com.twu.biblioteca;

import java.io.PrintStream;

public class ListBooksCommand implements Command {

    private PrintStream ps;
    private Library library;

    public ListBooksCommand(PrintStream ps, Library library) {
        this.ps = ps;
        this.library = library;
    }

    public void execute() {
        ps.println(library);
    }
}
