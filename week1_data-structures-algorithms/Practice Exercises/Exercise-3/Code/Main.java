public class Main {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 5000.0),
            new Order("O002", "Bob", 2500.0),
            new Order("O003", "Charlie", 10000.0),
            new Order("O004", "David", 7500.0)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        // quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nSorted Orders by Quick Sort:");
        for (Order o : orders) System.out.println(o);

        // bubble sort 
        bubbleSort(orders);
        System.out.println("\nSorted Orders by Bubble Sort:");
        for (Order o : orders) System.out.println(o);
    }
}