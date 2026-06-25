public class AssertionsTest {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        if (a != 2 + b) throw new AssertionError("expected 5");
        if (!(a > b)) throw new AssertionError("expected true");
        if (a < b) throw new AssertionError("expected false");

        Object nullObj = getNullObject();
        if (nullObj != null) throw new AssertionError("expected null");

        Object obj = getObject();
        if (obj == null) throw new AssertionError("expected not null");

        System.out.println("All checks passed");
    }

    private static Object getObject() {
        return new Object();
    }

    private static Object getNullObject() {
        return null;
    }
}