import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==================================");
            System.out.println("      Library Management System     ");
            System.out.println("==================================");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book by ISBN");
            System.out.println("3. Search book by title or author");
            System.out.println("4. Issue a book to a student");
            System.out.println("5. Return a book");
            System.out.println("6. Display all available books");
            System.out.println("7. Display all issued books");
            System.out.println("8. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 8.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = 0;
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity! Returning to menu.");
                        break;
                    }
                    library.addBook(title, author, isbn, quantity);
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    library.removeBook(removeIsbn);
                    break;

                case 3:
                    System.out.print("Enter title or author to search: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter book ISBN to issue: ");
                    String issueIsbn = scanner.nextLine();
                    library.issueBook(studentName, issueIsbn);
                    break;

                case 5:
                    System.out.print("Enter student name: ");
                    String returnStudentName = scanner.nextLine();
                    System.out.print("Enter book ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnStudentName, returnIsbn);
                    break;

                case 6:
                    library.displayAvailableBooks();
                    break;

                case 7:
                    library.displayIssuedBooks();
                    break;

                case 8:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option from 1 to 8.");
            }
        }
        scanner.close();
    }
}
