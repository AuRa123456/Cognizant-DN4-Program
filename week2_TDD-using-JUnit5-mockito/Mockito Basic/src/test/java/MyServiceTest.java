import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testMockingAndStubbing() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.logMessage("Hello Mockito");

        verify(mockApi).log(eq("Hello Mockito")); // using matcher
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).performAction();

        MyService service = new MyService(mockApi);
        service.triggerAction();

        verify(mockApi).performAction();
    }

    // Exercise 5: Mocking and Stubbing with Multiple Returns
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First Call", "Second Call");

        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.logMessage("Step 1");
        service.logMessage("Step 2");

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).log("Step 1");
        inOrder.verify(mockApi).log("Step 2");
    }

    // Exercise 7: Handling Void Methods with Exceptions
    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Failed")).when(mockApi).performAction();

        MyService service = new MyService(mockApi);

        try {
            service.triggerAction();
        } catch (RuntimeException e) {
            assertEquals("Failed", e.getMessage());
        }

        verify(mockApi).performAction();
    }
}