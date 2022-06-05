package lesson12;

public class TwoWayCount {
    public static void main(String[] args) {
    final int SIZE = 10000000;

        solidCount(SIZE);
        threadCount(SIZE);


    }


    private static void solidCount(int size) {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("solidCount:" + (System.currentTimeMillis() - a));
    }

    private static void threadCount(int size) {
        final int HALF = size / 2;
        float[] arr = new float[size];
        float[] arrFirstHalf = new float[HALF];
        float[] arrSecondHalf = new float[HALF];

        System.out.println("arr.l = " + arr.length + " arr1.l = " + arrFirstHalf.length + " arr1.l = " + arrSecondHalf.length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arrFirstHalf, 0, HALF);
        System.arraycopy(arr, HALF, arrSecondHalf, 0, HALF);


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arrFirstHalf.length; i++) {
                arrFirstHalf[i] = (float) (arrFirstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
        );


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrSecondHalf.length; i++) {
                    arrSecondHalf[i] = (float) (arrSecondHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrFirstHalf, 0, arr, 0, HALF);
        System.arraycopy(arrSecondHalf, 0, arr, HALF, HALF);

        System.out.println("threadCount:" + (System.currentTimeMillis() - a));
    }
}
