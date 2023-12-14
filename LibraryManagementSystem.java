import java.util.ArrayList;
import java.util.Scanner;


class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> searchBooks(String query) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        library.addBook(new Book("Book1", "Author1", 5));
        library.addBook(new Book("Book2", "Author2", 3));
        library.addBook(new Book("Book3", "Author3", 7));

        Scanner scanner = new Scanner(System.in);

        
        boolean isAdmin = false;
        System.out.println("Enter 'A' for Admin, 'U' for User:");
        String userType = scanner.nextLine();
        if (userType.equalsIgnoreCase("A")) {
            isAdmin = true;
            
        } else if (userType.equalsIgnoreCase("U")) {
            
            System.out.println("Welcome User!");
            while (true) {
                System.out.println("\nEnter your query (title/author) or 'exit' to quit:");
                String query = scanner.nextLine();
                if (query.equalsIgnoreCase("exit")) {
                    break;
                }
                ArrayList<Book> searchResult = library.searchBooks(query);
                if (searchResult.isEmpty()) {
                    System.out.println("No books found matching your query.");
                } else {
                    System.out.println("Search Results:");
                    for (Book book : searchResult) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Quantity: " + book.getQuantity());
                    }
                    
                }
            }
        } else {
            System.out.println("Invalid input. Exiting...");
        }

        scanner.close();
    }
}
