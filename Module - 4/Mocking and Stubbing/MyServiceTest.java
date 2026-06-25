interface ExternalApi {
    String getData();
}

class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    String fetchData() {
        return api.getData();
    }
}

public class MyServiceTest {
    public static void main(String[] args) {
        ExternalApi mockApi = new ExternalApi() {
            @Override
            public String getData() {
                return "Mock Data";
            }
        };

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        if (!"Mock Data".equals(result)) {
            throw new AssertionError("Expected 'Mock Data' but got: " + result);
        }
        
        System.out.println("Test passed successfully!");
    }
}