package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QuitCommandTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void testExecuteShouldThrowQuitProgramException() throws QuitBibliotecaException {
        thrown.expect(QuitBibliotecaException.class);
        thrown.expectMessage("Thank You! Visit Again");
            new QuitCommand().execute();
    }
}