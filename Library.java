import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Student> issuedRecords;
    private final String DATA_FILE = "library_data.ser";

    public Library() {
        books = new ArrayList<>();
        issuedRecords = new ArrayList<>();
        loadData();
    }

    // 1. Add a new book
    public void addBook(String title, String author, String isbn, int quantity) {
        // Check if book already exists
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                b.setQuantity(b.getQuantity() + quantity);
                System.out.println("Book exists. Quantity updated.");
                saveData();
                return;
            }
        }
        books.add(new Book(title, author, isbn, quantity));
        System.out.println("New book added successfully!");
        saveData();
    }

    // 2. Remove a book by ISBN
    public void removeBook(String isbn) {
        boolean removed = books.removeIf(b -> b.getIsbn().equalsIgnoreCase(isbn));
        if (removed) {
            System.out.println("Book removed successfully!");
            saveData();
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    // 3. Search book by title or author
    public void searchBook(String query) {
        boolean found = false;
        System.out.println("\n--- Search Results ---");
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase()) || 
                b.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching query: " + query);
        }
    }

    // 4. Issue a book to a student
    public void issueBook(String studentName, String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                if (b.getQuantity() > 0) {
                    b.setQuantity(b.getQuantity() - 1);
                    issuedRecords.add(new Student(studentName, isbn));
                    System.out.println("Book successfully issued to " + studentName);
                    saveData();
                    return;
                } else {
                    System.out.println("Book is currently out of stock!");
                    return;
                }
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
    }

    // 5. Return a book
    public void returnBook(String studentName, String isbn) {
        Student recordToRemove = null;
        for (Student s : issuedRecords) {
            if (s.getStudentName().equalsIgnoreCase(studentName) && s.getBorrowedBookIsbn().equalsIgnoreCase(isbn)) {
                recordToRemove = s;
                break;
            }
        }

        if (recordToRemove != null) {
            issuedRecords.remove(recordToRemove);
            for (Book b : books) {
                if (b.getIsbn().equalsIgnoreCase(isbn)) {
                    b.setQuantity(b.getQuantity() + 1);
                    break;
                }
            }
            System.out.println("Book returned successfully!");
            saveData();
        } else {
            System.out.println("No such issue record found for student: " + studentName + " and ISBN: " + isbn);
        }
    }

    // 6. Display all available books
    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // 7. Display all issued books
    public void displayIssuedBooks() {
        System.out.println("\n--- Issued Books ---");
        if (issuedRecords.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }
        for (Student s : issuedRecords) {
            System.out.println(s);
        }
    }

    // File handling: Save data via serialization
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(books);
            oos.writeObject(issuedRecords);
        } catch (IOException e) {
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }

    // File handling: Load data via serialization
    @SuppressWarnings("unchecked")
    private void loadData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                books = (ArrayList<Book>) ois.readObject();
                issuedRecords = (ArrayList<Student>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading library data. Starting fresh.");
                books = new ArrayList<>();
                issuedRecords = new ArrayList<>();
            }
        }
    }
}
