package com.twu.biblioteca;

public class Book {
    static  final String REQUEST_MESSAGE ="Enter the Book Name:";
    private String title;
    private String author;
    private Integer year;

    public Book(String title, String author,Integer year ) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (year != null ? !year.equals(book.year) : book.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return title + '-' + author + '-' + year;
    }

    public static String getHeader() {
        return "Title - Author - year of publication\n";
    }

    public boolean isSame(String bookName) {
        return bookName.equals(title);
    }
}
