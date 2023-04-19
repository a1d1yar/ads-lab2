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
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(7);
        list.printList();
        System.out.println(list.isSortable());
        list.sort();
        list.printList();

    }
}
