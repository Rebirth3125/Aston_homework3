public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);

        System.out.println("Before sorting:");
        System.out.println(list);

        list.bubbleSort();

        System.out.println("After sorting:");
        System.out.println(list);
    }
}
