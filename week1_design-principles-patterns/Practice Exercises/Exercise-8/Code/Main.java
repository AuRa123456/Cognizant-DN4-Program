interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Credit Card [" + cardHolderName + ", " + cardNumber + "]");
    }
}

class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using PayPal [" + email + "]");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment method not selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "Alice Mohanty");
        PaymentStrategy paypal = new PayPalPayment("am@example.com");

        System.out.println("\n--- Paying with Credit Card ---");
        context.setPaymentStrategy(creditCard);
        context.processPayment(150.75);

        System.out.println("\n--- Paying with PayPal ---");
        context.setPaymentStrategy(paypal);
        context.processPayment(89.99);
    }
}