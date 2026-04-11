import java.io.Serializable;

// Represents a record of a student issuing a specific book.
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentName;
    private String borrowedBookIsbn;

    public Student(String studentName, String borrowedBookIsbn) {
        this.studentName = studentName;
        this.borrowedBookIsbn = borrowedBookIsbn;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBorrowedBookIsbn() {
        return borrowedBookIsbn;
    }

    @Override
    public String toString() {
        return "Student: " + studentName + " | Borrowed Book ISBN: " + borrowedBookIsbn;
    }
}
