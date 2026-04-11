import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String isbn;
    private int quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Title: " + title + " | Author: " + author + " | Quantity: " + quantity;
    }
}
