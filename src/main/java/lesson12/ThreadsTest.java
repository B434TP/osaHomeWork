package lesson12;

public class ThreadsTest {
    private static Object m1;
    private static Object m2;

    private static final int DELAY = 200;

    public static void main(String[] args) throws InterruptedException {


        Thread t1A = new Thread(() -> {
            prnLetter("A", 30);
        }, "T1-A");

        Thread t2Pl = new Thread(() -> {
            prnLetter2("+", 30);
        }, "T2-+");

        Thread t3B = new Thread(() -> {
            prnLetter3("B", 30);
        }, "T3-B");

        m1 = new Object();
//        m2 = new Object();
        m2 = m1;

        t1A.start();
        t2Pl.start();
        t3B.start();

        t1A.join();
//        t2.join();
//        t3.join();
    }

    private static void prnLetter(String letter, int count) {
        synchronized (m1) {
            for (int i = 0; i < count; i++) {
                System.out.print(" "+ letter + i);
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void prnLetter2(String letter, int count) {
        synchronized (m2) {
            for (int i = 0; i < count; i++) {
                System.out.print(" "+ letter + i);
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void prnLetter3(String letter, int count) {
        synchronized (m1) {
            for (int i = 0; i < count; i++) {
                System.out.print(" "+ letter + i);
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
