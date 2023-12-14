package array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
    class Book {
        String title;
        String author;
        boolean isAvailable;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }
    }

        public class LibraryManagementSystem {
            private static ArrayList<BookA> bookList = new ArrayList<>();
            private static Scanner scanner = new Scanner(System.in);

            public static void main(String[] args) {
                while (true) {
                    System.out.println("Library Management System");
                    System.out.println("1. Add Book");
                    System.out.println("2. Display Books");
                    System.out.println("3. Borrow Book");
                    System.out.println("4. Return Book");
                    System.out.println("5. Delete Book");
                    System.out.println("6.Exit");
                    System.out.print("Enter your choice: ");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            addBook();
                            break;
                        case 2:
                            displayBooks();
                            break;
                        case 3:
                            borrowBook();
                            break;
                        case 4:
                            returnBook();
                            break;
                        case 5:
                            deleteBook();
                            break;

                        case 6:
                            System.out.println("Exiting the program. Goodbye!");
                            System.exit(0);


                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            }

            private static void addBook() {
                System.out.print("Enter the title of the book: ");
                String title = scanner.next();
                System.out.print("Enter the author of the book: ");
                String author = scanner.next();

                BookA newBook = new BookA(title, author);
                bookList.add(newBook);

                System.out.println("Book added successfully!");
            }

            private static void displayBooks() {
                if (bookList.isEmpty()) {
                    System.out.println("No books available in the library.");
                } else {
                    System.out.println("List of Books:");
                    for (BookA book : bookList) {
                        System.out.println("Title: " + book.title + ", Author: " + book.author + ", Available: " + (book.isAvailable ? "Yes" : "No"));
                    }
                }
            }

            private static void borrowBook() {
                System.out.print("Enter the title of the book to borrow: ");
                String title = scanner.next();

                for (BookA book : bookList) {
                    if (book.title.equalsIgnoreCase(title)) {
                        if (book.isAvailable) {
                            book.isAvailable = false;
                            System.out.println("Book '" + title + "' borrowed successfully!");
                        } else {
                            System.out.println("Sorry, the book '" + title + "' is not available for borrowing.");
                        }
                        return;
                    }
                }

                System.out.println("Book not found in the library.");
            }

            private static void returnBook() {
                System.out.print("Enter the title of the book to return: ");
                String title = scanner.next();

                for (BookA book : bookList) {
                    if (book.title.equalsIgnoreCase(title)) {
                        if (!book.isAvailable) {
                            book.isAvailable = true;
                            System.out.println("Book '" + title + "' returned successfully!");
                        } else {
                            System.out.println("This book is already available in the library.");
                        }
                        return;
                    }
                }

                System.out.println("Book not found in the library.");
            }

            private static void deleteBook() {
                System.out.print("Enter the title of the book to delete: ");
                String title = scanner.next();

                Iterator<BookA> iterator = bookList.iterator();
                while (iterator.hasNext()) {
                    BookA book = iterator.next();
                    if (book.title.equalsIgnoreCase(title)) {
                        iterator.remove();
                        System.out.println("Book '" + title + "' deleted successfully!");
                        return;
                    }
                }


            }
        }
