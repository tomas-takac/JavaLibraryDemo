package members.model;

import java.util.ArrayList;
import java.util.List;

public record Member(String name, String membershipId, List<Book> borrowedBooks) {

    public Member(String name, String membershipId) {
        this(name, membershipId, new ArrayList<>());
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
