import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


class Philosopher extends Thread {
    private static Random rnd = new Random();
    private static int cnt = 0;
    private int num = cnt++;
    private Spoon leftSpoon;
    private Spoon rightSpoon;
    static int waiting = 0;

    static ReentrantLock lock = new ReentrantLock();

    public Philosopher(Spoon left, Spoon right) {
        leftSpoon = left;
        rightSpoon = right;
        start();
    }
    public void think() {
        System.out.println(this + " is thinking");
        if (waiting > 0) {
            try {
                sleep(rnd.nextInt(waiting));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void eat() {
        try {
            //Philosopher.lock.lock();
            synchronized (leftSpoon) {
                System.out.println(this + " has " + this.leftSpoon + " Waiting for " + this.rightSpoon);
                synchronized (rightSpoon) {
                    System.out.println(this + " eating");
                }
            }
        }
        finally {
            //Philosopher.lock.unlock();
        }

    }
    @Override
    public String toString() {
        return "Philosopher " + num;
    }
    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }
}
