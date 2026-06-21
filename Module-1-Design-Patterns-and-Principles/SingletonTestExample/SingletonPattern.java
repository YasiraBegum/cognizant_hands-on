class Logger{
    private static Logger instance = null;
    private Logger() {
        System.out.println("Logger instance created");
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

class Main{
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log");

        System.out.println("Are both logger instances the same? " + (logger1 == logger2));
    }
}