# Java Library Management System 📚

A robust and reliable Library Management System built with Core Java. This application provides a complete Command-Line Interface (CLI) to seamlessly manage books and track book reservations by students. Data is stored safely using Java Object Serialization, meaning all your inventory and student records persist across multiple sessions.

## Team Members
- Divyansh (Roll No. 5)
- Apoorva (Roll No. 2)
- Janmajay (Roll No. 7)
- anurag (roll no. 17)

Group: 5  
Project: Library Management System

## 🌟 Features

* **Add Books:** Register new entries with Title, Author, unique ISBN, and total quantity. If an entry exists, the quantity updates automatically.
* **Remove Books:** Delete books from the system completely using their unique ISBN.
* **Search Books:** Look up library records easily by performing case-insensitive string matching on the Title or Author fields.
* **Issue Books to Students:** Track who has checked out which book. Ensures you cannot issue a book if the stock hits 0.
* **Return Books:** Easily verify returns. The system re-adds the returned copy to the library stock.
* **Display Catalog:** Separate, readable listings of **Available Books** and currently **Issued Books**.
* **Automatic Data Persistence:** Data is securely backed up and re-loaded continuously from a serialized local file (`library_data.ser`). No external database required! 

## 🛠️ Technology Stack

* **Language:** Java (JDK 8 or higher)
* **Data Storage:** Java Object Serialization (Binary File I/O)
* **Data Structures:** Standard `java.util.ArrayList`

## 📂 File Structure

```text
├── Book.java       - Data model representing Library Books
├── Student.java    - Data model representing Borrowing Students
├── Library.java    - Core logic and repository, manages File I/O algorithms
├── Main.java       - CLI Menu interaction and user-input handling
└── README.md       - Project documentation
```

## 🚀 Getting Started

### Prerequisites

You need the Java SE Development Kit (JDK) installed on your system. You can verify it by opening your terminal or command prompt and running:
```bash
java -version
javac -version
```

### Installation & Execution

1. Clone or download all `.java` files from this repository into a single directory.
2. Open your terminal or command prompt and navigate to the project directory:
   ```bash
   cd path/to/your/project/directory
   ```
3. Compile all the Java files using `javac`:
   ```bash
   javac *.java
   ```
4. Run the main application file:
   ```bash
   java Main
   ```

## 🛡️ Exception Handling & Safety

The CLI has been fortified to reject malformed input strings gracefully without causing system-halting exceptions. This ensures the Library Management System never crashes unexpectedly during the runtime menu loop.
