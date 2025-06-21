public class Main {
    public static void main(String[] args) {
        // basic
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();

        // high end
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("2TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setMotherboard("Asus ROG")
                .setPowerSupply("850W Gold")
                .build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
    }
}