import java.util.Timer;
import java.util.TimerTask;

class Timeout extends Timer {
    public Timeout(int delay, final String msg) {
        super(true);
        schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(msg);
                System.exit(0);
            }
        }, delay);
    }
}
