public class Main {
    public static void main(String[] args) {
       /* MyList1 arr = new MyList1<>();
        arr.add("5");
        arr.add("2");
        arr.add("3");
        arr.add("4");

        arr.printList();

        */
        LinkedList list = new LinkedList<>();
        list.add(2.0);
        list.add(5.0);
        list.add(1.1);
        list.add(6.4);
        list.add(7.5);
        list.printList();
        list.sort();
        list.printList();

    }
}
