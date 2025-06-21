interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        // email only
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Your order has been shipped.");

        System.out.println("\n--- Adding SMS ---");
        // email + SMS
        Notifier emailWithSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailWithSMS.send("Your package has arrived.");

        System.out.println("\n--- Adding SMS + Slack ---");
        // Email + SMS + slack
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        allChannels.send("System maintenance scheduled for tonight.");
    }
}
