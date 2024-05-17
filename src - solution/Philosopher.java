import java.util.Random;

/**
 * Created by fha on 30-04-2017.
 */
class Philosopher extends Thread {
    private static Random rnd = new Random();
    private static int cnt = 0;
    private int num = cnt++;
    private Spoon leftSpoon;
    private Spoon rightSpoon;
    static int waiting = 0;

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
        if(!leftSpoon.getTaken() && !rightSpoon.getTaken() )
        synchronized (leftSpoon) {
            leftSpoon.setTaken(true);
            rightSpoon.setTaken(true);
            System.out.println(this + " has " + this.leftSpoon + " Waiting for " + this.rightSpoon);
            synchronized (rightSpoon) {
                System.out.println(this + " eating");
                leftSpoon.setTaken(false);
                rightSpoon.setTaken(false);
            }
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
