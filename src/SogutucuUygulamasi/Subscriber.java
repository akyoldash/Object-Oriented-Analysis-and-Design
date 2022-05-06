package SogutucuUygulamasi;

public class Subscriber implements IObserver{
    @Override
    public void update(String message) {
        System.out.println("Abone: " + message);
    }
}
