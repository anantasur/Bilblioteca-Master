package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private Library library;
    private final Menu menu;
    private boolean keepRunning;

    public Biblioteca() {
        init();
        this.menu = new Menu();
        menu.addItem(new MenuItem("List Books", new ListBooksCommand(System.out, library)));
        menu.addItem(new MenuItem("Checkout Book", new CheckOutCommand(library,System.in,System.out)));
        menu.addItem(new MenuItem("Return Book", new ReturnCommand(library,System.in,System.out)));
        menu.addItem(new MenuItem("Quit", new QuitCommand()));
    }

    private void init(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Wings of Fire","A. P. J. Abdul Kalam",2004));
        bookList.add(new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle",1987));
        bookList.add(new Book("Ramayana", "Valmiki",2001));
        bookList.add(new Book("Five Point Someone", "Chetan Bhagat",2010));
        this.library = new Library(bookList);

        keepRunning = true;

    }

    public void run() {
        printWelcomeMessage(System.out);
        while (keepRunning) {
            System.out.println(menu);
            System.out.println("Enter option number:");
            Scanner scan = new Scanner(System.in);
            try {
                optionHandler(scan.nextInt());
            } catch (Exception e) {
                System.out.println("OOPS!!! Some unknown error occurred!!\n" + e);
            }
        }
    }

    public void printWelcomeMessage(PrintStream printStream) {
        printStream.println("Welcome to Biblioteca.");
    }

    public void optionHandler(int option) {
        try {
            menu.handleOption(option);
        } catch (QuitBibliotecaException e) {
            System.out.println(e.getMessage());
            keepRunning = false;
        } catch (InvalidOptionException e) {
            System.out.println(e.getMessage());
        }
    }
}
