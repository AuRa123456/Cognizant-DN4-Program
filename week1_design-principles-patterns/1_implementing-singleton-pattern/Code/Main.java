public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("1st log message.");
        logger2.log("2nd log message.");

        if (logger1 == logger2) {
            System.out.println("Both log1 and log2 are the same instance.");
        } else {
            System.out.println("log1 and log2 are different instances.");
        }
    }
}