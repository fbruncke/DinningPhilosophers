/**
 * Created by fha on 30-04-2017.
 */
public class Spoon {

    private static int cnt = 0;
    private int num = cnt++;

    public synchronized Boolean getTaken() {
        return taken;
    }

    public synchronized void setTaken(Boolean taken) {
        this.taken = taken;
    }

    private Boolean taken = false;


    @Override
    public String toString() {
        return "Spoon " + num;
    }

}
