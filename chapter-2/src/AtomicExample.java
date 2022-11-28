public class AtomicExample {
    volatile int i = 0;

    public void incr() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicExample atomicExample = new AtomicExample();
        Thread[] threads = new Thread[2];
        for (int j = 0; j < 2; j++) {
            threads[j] = new Thread(() -> {
                for (int k = 0; k < 100000000; k++) {
                    atomicExample.incr();
                }
            });
            threads[j].start();
        }
        threads[0].join(); //保证线程执行结束
        threads[1].join();
        System.out.println(atomicExample.i);
    }
}
