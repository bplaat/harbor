package ml.bastiaan.containership;

public class Worker implements Runnable {
    protected final String name;
    protected final Thread thread;

    public Worker(String name) {
        this.name = name;
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name + " tick");
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    public void start() {
        thread.start();
    }

    public String getName() {
        return name;
    }
}
