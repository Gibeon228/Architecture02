package singleton;

public class Program {

    public static void main(String[] args) {
        Singleton singleton;

        BaseClient client1 = new Client01("Alex");
        singleton = client1.getSingleton();
        System.out.println(singleton);
//      System.out.println(singleton.NAME);
    }
}
