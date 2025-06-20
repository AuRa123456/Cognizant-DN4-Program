import java.util.Arrays;
import java.util.Comparator;

public class Library {
    Book[] books;
    int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(String id, String title, String author) {
        if (count < books.length) {
            books[count++] = new Book(id, title, author);
        } else {
            System.out.println("Library is full.");
        }
    }

    public void listBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    // Linear search by title
    public void linearSearch(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Binary search by title (assumes sorted list)
    public void binarySearch(String title) {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle));
        int low = 0, high = count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                System.out.println("Found: " + books[mid]);
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Book not found.");
    }
}