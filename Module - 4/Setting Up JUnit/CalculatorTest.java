class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int expected = 30;
        int actual = calc.add(10, 20);
        if (expected != actual) {
            System.err.println("Test failed: expected=" + expected + " actual=" + actual);
            System.exit(1);
        }
        System.out.println("Test passed");
    }
}
