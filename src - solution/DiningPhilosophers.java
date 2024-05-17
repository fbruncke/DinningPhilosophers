/**
 * Created by fha on 30-04-2017.
 */
public class DiningPhilosophers {

    private static boolean gotoDeadLock =true;

    public static void main(String[] args) {
        Philosopher[] phil = new Philosopher[10];
        Philosopher.waiting = 8;
        Spoon left = new Spoon(), right = new Spoon(), first = left;
        int i = 0;
        while (i < phil.length - 1) {
            phil[i++] = new Philosopher(left, right);
            left = right;
            right = new Spoon();
        }
        if (gotoDeadLock) {
            phil[i] = new Philosopher(left, first);
        } else
        {
            phil[i] = new Philosopher(first, left);
        }
        if (args.length >= 4) {
            int delay = 3;
            if (delay != 0) {
                Timeout timeout = new Timeout(delay * 1000, "Timed out");
            }
        }
    }

}
