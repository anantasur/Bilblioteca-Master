package com.twu.biblioteca;

public class QuitCommand implements Command {

    public void execute() throws QuitBibliotecaException {
        throw new QuitBibliotecaException("Thank You! Visit Again");
    }
}
