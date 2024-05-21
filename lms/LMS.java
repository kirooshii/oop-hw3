package lms;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class LMS {

    List<Book> books = new ArrayList<>();
    private List<Book> borrowedBooks = new ArrayList<>();

    // add the book to the library and print a message
    public void addBook(Book book) {
        books.add(book);
        System.out.println("The new book was added: " + book.getTitle() + " by " + book.getAuthor());
    }

    // remove the book from the library and print a message
    public boolean removeBook(Book book) {
        boolean removed = false;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor())) {
                books.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("The" + book.getTitle() + " by " + book.getAuthor() + "was removed from the library");
        }

        return removed;
    }

    public void borrowBook(Book book, Student student) {
        if (book != null && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            System.out.println(book.getTitle() + " is borrowed");
        } else {
            System.out.println("Sorry, this book is not available");
        }
    }

    public boolean returnBook(Book book) {
        boolean returned = false;
        if (book != null && borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            System.out.println(book.getTitle() + " is returned");
            returned = true;
        } else {
            System.out.println("This book is not borrowed!");
        }
        return returned;
    }

    public void saveState(String fylePath) {

        try (PrintWriter writer = new PrintWriter(fylePath)) {
            for (Book b: books) {
                writer.println(b.getTitle() + ", " + b.getAuthor());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        System.out.println("The library state was saved");
    }

    public boolean loadState(String fylePath) {
        boolean returned = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(fylePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                Book b = new Book(parts[0], parts[1]);
                books.add(b);
            }
            returned = true;
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: IO Exception.");
        }
        return returned;
    }

}
