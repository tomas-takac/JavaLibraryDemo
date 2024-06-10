package members.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(String membershipId, Book book) {
        Optional<Member> memberOptional = findMemberById(membershipId);
        if (memberOptional.isPresent() && books.contains(book)) {
            memberOptional.get().borrowBook(book);
            books.remove(book);
        }
    }

    public void returnBook(String membershipId, Book book) {
        Optional<Member> memberOptional = findMemberById(membershipId);
        if (memberOptional.isPresent()) {
            memberOptional.get().returnBook(book);
            books.add(book);
        }
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public List<Member> listMembers() {
        return new ArrayList<>(members);
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.author().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.genre().equals(genre))
                .collect(Collectors.toList());
    }

    public int countBooks() {
        return books.size();
    }

    public int countMembers() {
        return members.size();
    }

    private Optional<Member> findMemberById(String membershipId) {
        return members
                .stream()
                .filter(member -> member.membershipId().equals(membershipId))
                .findFirst();
    }
}
