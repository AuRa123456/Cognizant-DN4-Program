class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class Task {
    String taskId;
    String taskName;
    String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return taskId + " | " + taskName + " | " + status;
    }
}

class TaskManager {
    Node head = null;

    public void addTask(String id, String name, String status) {
        Task newTask = new Task(id, name, status);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("Task added.");
    }

    // Search tasks
    public void searchTask(String id) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId.equals(id)) {
                System.out.println("Found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    // Traverse tasks
    public void listTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks to show.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete tasks
    public void deleteTask(String id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId.equals(id)) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.taskId.equals(id)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask("T001", "Design UI", "Pending");
        manager.addTask("T002", "Write Backend", "In Progress");
        manager.addTask("T003", "Testing", "Pending");

        System.out.println("\nTask List:");
        manager.listTasks();

        System.out.println("\nSearch for T002:");
        manager.searchTask("T002");

        System.out.println("\nDeleting T001:");
        manager.deleteTask("T001");

        System.out.println("\nUpdated Task List:");
        manager.listTasks();
    }
}
