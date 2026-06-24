// Use fully-qualified JUnit types to avoid unresolved import issues when junit
// is not present on the compile classpath in some IDEs or environments.

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {

    private Calculator calc;

    // Setup method (invoked manually to avoid JUnit dependency)
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup: Calculator object created");
    }

    // Teardown method (invoked manually to avoid JUnit dependency)
    public void tearDown() {
        calc = null;
        System.out.println("Teardown: Calculator object destroyed");
    }

    public void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calc.add(a, b);

        // Assert (simple check to avoid JUnit dependency)
        if (result != 30) {
            throw new AssertionError("Expected 30 but got " + result);
        }
        System.out.println("testAdd passed");
    }

    // Simple runner to execute the test without JUnit on the classpath
    public static void main(String[] args) {
        CalculatorTest t = new CalculatorTest();
        t.setUp();
        try {
            t.testAdd();
        } finally {
            t.tearDown();
        }
    }
}