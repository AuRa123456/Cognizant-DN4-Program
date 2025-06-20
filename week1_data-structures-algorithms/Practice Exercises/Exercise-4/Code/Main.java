public class Main {
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    // Add employee
    public static void addEmployee(String id, String name, String position, double salary) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = new Employee(id, name, position, salary);
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee limit reached.");
        }
    }

    // Search employee
    public static void searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                System.out.println("Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Traverse all employees
    public static void listEmployees() {
        if (count == 0) {
            System.out.println("No employees to show.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee
    public static void deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        addEmployee("E001", "Alice", "Manager", 70000);
        addEmployee("E002", "Bob", "Developer", 50000);
        addEmployee("E003", "Charlie", "Designer", 45000);

        System.out.println("\nEmployee List:");
        listEmployees();

        System.out.println("\nSearch for E002:");
        searchEmployee("E002");

        System.out.println("\nDeleting E001:");
        deleteEmployee("E001");

        System.out.println("\nUpdated Employee List:");
        listEmployees();
    }
}