package singleton;

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    public Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
