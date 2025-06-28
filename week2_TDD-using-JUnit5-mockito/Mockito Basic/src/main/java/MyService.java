public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void triggerAction() {
        api.performAction();
    }

    public void logMessage(String message) {
        api.log(message);
    }
}