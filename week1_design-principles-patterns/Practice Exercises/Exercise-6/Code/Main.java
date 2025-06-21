interface Image {
    void display();
}

class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        } else {
            System.out.println("Image already loaded. Using cached image: " + filename);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("landscape.jpg");
        Image image2 = new ProxyImage("portrait.png");

        System.out.println("\n--- First display of landscape.jpg ---");
        image1.display();

        System.out.println("\n--- Second display of landscape.jpg ---");
        image1.display();

        System.out.println("\n--- First display of portrait.png ---");
        image2.display();
    }
}