package members;

import members.model.Book;
import members.model.Library;
import members.model.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Title1", "Author1", 2001, "Genre1");
        Book book2 = new Book("Title2", "Author2", 2002, "Genre2");
        Book book3 = new Book("Title3", "Author1", 2003, "Genre1");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Member member1 = new Member("Member1", "ID1");
        Member member2 = new Member("Member2", "ID2");

        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook("ID1", book1);

        System.out.println("All Books: " + library.listBooks());
        System.out.println("All Members: " + library.listMembers());
        System.out.println("Books by Author1: " + library.findBooksByAuthor("Author1"));
        System.out.println("Books in Genre1: " + library.findBooksByGenre("Genre1"));
        System.out.println("Total number of books: " + library.countBooks());
        System.out.println("Total number of members: " + library.countMembers());

        library.returnBook("ID1", book1);

        System.out.println("All Books after return: " + library.listBooks());
    }
}
