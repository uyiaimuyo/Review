/**
 * Created by Aysar on 8/25/2014.
 */
public class Singleton {
    // to use in another class, you just do:
    // Singleton s = Singleton.getInstance();

    private static Singleton instance = new Singleton();
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    // old way, with lazy instantiation but not thread safe
    public static Singleton getInstanceOld() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
