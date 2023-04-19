public class LinkedList<T> implements MyList{
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public void printList() {
        if (size == 0) {
            System.out.println(" List is empty");
            return;
        }

        Node<T> current = head;
        System.out.print("Linked List elements: ");

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" , ");
            }

            current = current.next;
        }

        System.out.println();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }



    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        if (index == size) {
            add(item);
            return;
        }
        Node<T> newNode = (Node<T>) new Node<>(item, null, null);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else {
            Node<T> ptr = getNode(index - 1);
            Node<T> nextNode = ptr.next;
            ptr.next = newNode;
            newNode.prev = ptr;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    private Node<T> getNode(int index) {
        Node<T> ptr = head;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }



    @Override
    public boolean remove(Object item) {
        Node<T> ptr = head;
        while (ptr != null) {
            if (ptr.val.equals(item)) {
                if (ptr == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (ptr == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    Node<T> prevNode = ptr.prev;
                    Node<T> nextNode = ptr.next;
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                }
                size--;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }


        @Override
    public Object remove(int index) {
            checkIndex(index);
            if (index == 0) {
                T removed = head.val;
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                size--;
                return removed;
            }
            if (index == size - 1) {
                T removed = tail.val;
                tail = tail.prev;
                tail.next = null;
                size--;
                return removed;
            }
            Node<T> ptr = getNode(index);
            Node<T> prevNode = ptr.prev;
            Node<T> nextNode = ptr.next;
            T removed = ptr.val;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
            return removed;
        }




            @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
    public void checkIndex(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
    }
}