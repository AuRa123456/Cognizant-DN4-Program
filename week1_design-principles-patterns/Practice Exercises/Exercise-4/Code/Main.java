interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amountInDollars) {
        System.out.println("Payment of Rs. " + amountInDollars + " made through PayPal.");
    }
}

class StripeGateway {
    public void pay(double amountInRupees) {
        System.out.println("Payment of Rs. " + amountInRupees + " made through Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        System.out.println("Processing payments:");
        paypalProcessor.processPayment(150.00);
        stripeProcessor.processPayment(12000.00);
    }
}
