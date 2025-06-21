public class Computer {
    private final String CPU;
    private final String RAM;

    private final String storage;
    private final String graphicsCard;
    private final String motherboard;
    private final String powerSupply;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String motherboard;
        private String powerSupply;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU = " + CPU + ", RAM = " + RAM + ", Storage = " + storage + ", GraphicsCard = " + graphicsCard + ", Motherboard = " + motherboard + ", PowerSupply = " + powerSupply + "]";
    }
}