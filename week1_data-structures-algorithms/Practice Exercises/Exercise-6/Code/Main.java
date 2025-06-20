public class Main {
    public static void main(String[] args) {
        Library lib = new Library(10);

        lib.addBook("B001", "Java Prog", "James Gosling");
        lib.addBook("B002", "Python Basics", "Guido van Rossum");
        lib.addBook("B003", "C++", "Stanley Lippman");
        lib.addBook("B004", "DSA", "Mark Weiss");

        System.out.println("\nAll Books:");
        lib.listBooks();

        System.out.println("\nLinear Search for 'Python Basics':");
        lib.linearSearch("Python Basics");

        System.out.println("\nBinary Search for 'Java Prog':");
        lib.binarySearch("Java Prog");

        System.out.println("\nBinary Search for 'Algos':");
        lib.binarySearch("Algorithms");
    }
}
