package singleton;

public abstract class BaseClient {
    String name;

    public BaseClient(String name) {
        this.name = name;
    }

    public Singleton getSingleton() {
        return Singleton.getInstance();
    }
}
