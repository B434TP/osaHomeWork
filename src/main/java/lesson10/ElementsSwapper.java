package lesson10;

public class ElementsSwapper<E> {
    private E[] arr;

//    public void setArr(E[] arr) {
//        this.arr = arr;
//    }

    public void swap(int indexA, int indexB) {
        E temp;
        temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public ElementsSwapper(E[] arr) {
        this.arr = arr;
    }

    public void printArr() {
        System.out.println("----------------");
        for (E item : arr) {
            System.out.println(item);
        }
    }
}
