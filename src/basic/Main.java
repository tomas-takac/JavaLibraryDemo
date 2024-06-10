package basic;

import basic.model.Book;
import basic.model.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Title1", "Author1", 2001));
        library.addBook(new Book("Title2", "Author2", 2002));
        library.addBook(new Book("Title3", "Author1", 2003));

        System.out.println("All Books: " + library.listBooks());
        System.out.println("Books by Author1: " + library.findBooksByAuthor("Author1"));
        System.out.println("Total number of books: " + library.countBooks());
    }
}
