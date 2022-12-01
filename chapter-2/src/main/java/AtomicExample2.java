public class AtomicExample2 {
    volatile int i = 0;

    public synchronized void incr() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicExample2 atomicExample2 = new AtomicExample2();
        Thread[] threads = new Thread[2];
        for (int j = 0; j < 2; j++) {
            threads[j] = new Thread(() -> {
                for (int k = 0; k < 100000000; k++) {
                    atomicExample2.incr();
                }
            });
            threads[j].start();
        }
        threads[0].join(); //保证线程执行结束
        threads[1].join();
        System.out.println(atomicExample2.i);
    }
}
