/**
 * Created by fha on 30-04-2017.
 */
public class Spoon {

    private static int cnt = 0;
    private int num = cnt++;
    @Override
    public String toString() {
        return "Spoon " + num;
    }
//synchronized
    //public  Boolean getTaken() {
   //     return taken;
   // }

    //synchronized
    //public void setTaken(Boolean taken) {
 //       this.taken = taken;
   // }

    private Boolean taken = false;

}
