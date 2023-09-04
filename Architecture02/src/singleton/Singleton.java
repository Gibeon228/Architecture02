package singleton;

public class Singleton {

//  protected static final String NAME = "Phone";
    private static final Singleton INSTANCE = new Singleton();

    public Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
