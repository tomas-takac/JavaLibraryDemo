package basic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<basic.model.Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(basic.model.Book book) {
        books.add(book);
    }

    public List<basic.model.Book> listBooks() {
        return books;
    }

    public List<basic.model.Book> findBooksByAuthor(String author) {
        return books.stream().filter(book -> book.author().equals(author)).collect(Collectors.toList());
    }

    public int countBooks() {
        return books.size();
    }
}
