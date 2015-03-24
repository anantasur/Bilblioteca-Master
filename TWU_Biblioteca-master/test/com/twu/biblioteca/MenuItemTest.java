package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuItemTest {
    @Test
    public void testThatFunctionGetNameGiveTheNameInMenuItem() {
        MenuItem menuItem = new MenuItem("Quit", new QuitCommand());
        assertEquals("Quit", menuItem.getName());
    }

}