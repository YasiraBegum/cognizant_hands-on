interface ExternalApi {
    void processData(String data);
}

class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void doWork() {
        api.processData("Important Payload");
    }
}

public class MyServiceTest {
    public static void main(String[] args) {
        // A simple manual mock to verify interactions
        class MockExternalApi implements ExternalApi {
            private String receivedData = null;

            @Override
            public void processData(String data) {
                this.receivedData = data;
                System.out.println("Mock received: " + data);
            }

            public String getReceivedData() {
                return receivedData;
            }
        }

        MockExternalApi mockApi = new MockExternalApi();
        
        MyService service = new MyService(mockApi);
        service.doWork();

        // verify interaction
        if ("Important Payload".equals(mockApi.getReceivedData())) {
            System.out.println("Verification passed successfully!");
        } else {
            System.out.println("Verification failed: expected 'Important Payload' but was '" + mockApi.getReceivedData() + "'");
        }
    }
}