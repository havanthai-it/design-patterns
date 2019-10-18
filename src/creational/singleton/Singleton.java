package creational.singleton;

public final class Singleton {
    private static volatile Singleton _instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                _instance = new Singleton();
            }
        }
        return _instance;
    }
}
