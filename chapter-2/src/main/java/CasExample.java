public class CasExample {

    public volatile int i;

    public synchronized void incr(int expect) {
        if (i == expect) {
            i++;
        }
    }
}
