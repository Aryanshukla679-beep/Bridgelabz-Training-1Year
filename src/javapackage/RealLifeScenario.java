package javapackage;

public class Book {

    String bookTitle;
    String author;

    public Book(String title, String author) {
        this.bookTitle = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Author: " + author);
    }
}package javapackage.members;

public class Member {

    String memberName;
    int memberId;

    public Member(String name, int id) {
        this.memberName = name;
        this.memberId = id;
    }

    public void displayMember() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
    }
}package javapackage.transactions;

import javapackage.books.Book;
import javapackage.members.Member;

public class Transaction {

    public void issueBook(Book b, Member m) {

        System.out.println("Book Issued Successfully!");
        System.out.println("Book Details:");
        b.displayBook();

        System.out.println("Issued To:");
        m.displayMember();
    }
}