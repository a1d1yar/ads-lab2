public class LinkedList<T> implements MyList{
    /**
     * every element is Node which have 3 parameters - value of element, reference to next and previous elements
     */
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        /**
         * @function Node - constructor to create Node with given item
         * @param val - given element to create node
         * @param next - reference to next Node
         * @param prev - reference to previous Node
         */
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * @function MyLinkedList - constructor that creating new linked list
     * @noparam
     * @return void
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /**
     * @function size - returning size of linked list
     * @noparam
     * @return int
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * @function isEmpty - checking is linked list empty or not
     * @norapam
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Prints the elements of the linked list to the console.
     *
     * @return void
     */
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
    /**
     *
     *Checks if the list contains the specified element.
     *@param o The element to search for in the list.
     *@return true if the element is present in the list, false otherwise.
     */
    @Override
    public boolean contains(Object o) {
        Node<T> ptr = head;
        while (ptr != null) {
            if (o.equals(ptr.val)) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    /**
     * Adds the specified element to the end of this list.
     *
     * @param item the element to be appended to this list
     * @return true (as specified by Collection.add(E))
     */
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

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */

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
    /**
     *
     *Returns the node at the specified index in this LinkedList.
     *@param index the index of the node to return
     *@return the node at the specified index in this LinkedList
     *@throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    private Node<T> getNode(int index) {
        Node<T> ptr = head;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }


    /**
     * Removes the first occurrence of the specified object from the list, if it is present.
     *
     * @param item the object to be removed from the list
     * @return true if the list contained the specified object, false otherwise
     */
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

    /**
     * Removes the node at the specified index from the list.
     *
     * @param index the index of the node to be removed
     * @return the data of the removed node
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
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
    /**
     * Removes all elements from this LinkedList.
     *
     * @return void
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * Retrieves the element at the specified index in this list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.val;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                return ptr.val;
            }
            ptr = ptr.next;
        }
        return null;
    }
    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (head.val == newNode.val) {
            return 0;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (ptr.val == newNode.val) {
                return i;
            }
            ptr = ptr.next;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object in this list.
     *
     * @param o the object to search for
     * @return the index of the last occurrence of the specified object, or -1 if not found
     */
    @Override
    public int lastIndexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        int index = size - 1;
        if (tail.val == newNode.val) {
            return index;
        }
        Node<T> ptr = tail.prev;
        while (ptr != null) {
            if (ptr.val == newNode.val) {
                return index;
            }
            index--;
            ptr = ptr.prev;
        }
        return -1;
    }

    /**
     * Sorts the elements of this LinkedList in ascending order.
     *
     * @return void
     */
    @Override
    public void sort() {
        if (isSortable()) {
            Node<T> front = head;
            Node<T> back = null;
            while (front != null) {
                back = front.next;
                while (back != null && back.prev != null && (Integer) back.val < (Integer) back.prev.val) {
                    swapValues(back, back.prev);
                    back = back.prev;
                }
                front = front.next;
            }
        }
    }
    /**
     * Checks if the given index is within the bounds of the LinkedList.
     *
     * @param index The index to check.
     * @return true if the index is within bounds, false otherwise.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void checkIndex(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Swaps the elements at the specified indices in this list.
     *
     * @param first the index of the first element to be swapped
     * @param second the index of the second element to be swapped
     *
     * @throws IndexOutOfBoundsException if either index is out of range
     */
    public void swapValues(Node<T> first, Node<T> second) {
        T value = first.val;
        first.val = second.val;
        second.val = value;
    }
    /**
     * Returns a boolean indicating if this LinkedList can be sorted using the sort method.
     *
     * @return true if the LinkedList is sortable, false otherwise
     */
    public boolean isSortable() {
        Node<T> ptr = head;
        int intSize = 0;
        int doubleSize = 0;
        for (int i = 1; i <= size; i++) {
            try {
                int value = (Integer) ptr.val ;
                intSize++;
            } catch (ClassCastException e) {
            }
            try {
                double tempD = (Double) ptr.val;
                doubleSize++;
            } catch (ClassCastException e) {
            }
            ptr = ptr.next;
        }
        System.out.println(intSize + " " + doubleSize);
        if (intSize == size || doubleSize == size || doubleSize + intSize == size) {
            return true;
        }
        return false;
    }
}
