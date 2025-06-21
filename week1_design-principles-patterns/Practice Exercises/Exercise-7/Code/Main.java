import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double price);
}

class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStockData(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {
    private final String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp (" + user + "): " + stockName + " price changed to Rs. " + price);
    }
}

class WebApp implements Observer {
    private final String user;

    public WebApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp (" + user + "): " + stockName + " price updated to $" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        System.out.println("\n--- First Update ---");
        market.setStockData("APPLE", 1920.50);

        System.out.println("\n--- Second Update ---");
        market.setStockData("GOOGLE", 2800.00);

        System.out.println("\n--- Removing WebApp ---");
        market.removeObserver(webUser);

        System.out.println("\n--- Third Update ---");
        market.setStockData("TESLA", 6200.10);
    }
}