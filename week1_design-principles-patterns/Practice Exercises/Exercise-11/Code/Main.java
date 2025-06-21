interface CustomerRepository {
    String findCustomerById(String customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String customerId) {
        return "Customer [ID: " + customerId + ", Name: Alice Johnson]";
    }
}

class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(String customerId) {
        String customer = customerRepository.findCustomerById(customerId);
        System.out.println("Customer Details: " + customer);
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("\n--- Fetching Customer ---");
        service.getCustomerDetails("C123");
    }
}