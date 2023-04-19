/**
 * A generic implementation of the MyList interface that stores elements in an array.
 *
 * @param <T> the type of elements stored in the list
 */
public class MyList1<T> implements MyList {

    /**
     * The array that stores the elements of the list.
     */
    private T[] arr;

    /**
     * The current size of the list (i.e., the number of elements it contains).
     */
    private int size;

    /**
     * Constructs a new MyList1 object with an initial capacity of 5.
     */
    public MyList1() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    /**
     * Increases the capacity of the array by doubling its size.
     */
    public void addArraySize() {
        int i;
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the list contains the specified element.
     *
     * @param o the element to search for
     * @return true if the list contains the element, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        boolean cont = false;
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == o) cont = true;
        }

        return cont;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param item the element to add
     */
    @Override
    public void add(Object item) {
        if (size == arr.length) {
            addArraySize();
        }
        arr[size++] = (T) item;
    }

    /**
     * Inserts the specified element at the specified position in the list.
     *
     * @param item  the element to add
     * @param index the position at which to add the element
     */
    @Override
    public void add(Object item, int index) {
        int i;
        if (size == arr.length) {
            addArraySize();
        }
        T[] newArr = (T[]) new Object[arr.length];

        for (i = 0; i < index; i++) newArr[i] = arr[i];
        for (i = 0; i < size; i++) {
            newArr[i + 1] = arr[i];
        }
    }

    /**
     * Removes the first occurrence of the specified element from the list, if it is present.
     *
     * @param item the element to remove
     * @return true if the list contained the specified element, false otherwise
     */
    @Override
    public boolean remove(Object item) {
        boolean rem = false;
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == item) {
                remove(i);
            }
        }
        return rem;
    }

/**
 * Removes the element at the specified position in the list.
 *
 * @param index the position of the element to remove
 * @return the removed element
 * @throws IndexOutOfBoundsException if the index
**/
 @Override
    public Object remove(int index) {
        checkIndex(index);
        int i ;
        for ( i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        return null;
    }
    /**
     * Removes all the elements from this list.
     */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--) {
            if(arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Checks if the given index is within the bounds of the list.
     * Throws an IndexOutOfBoundsException if the index is out of bounds.
     *
     * @param index the index to be checked
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Sorts the elements in the list in ascending order.
     * This method only works if the list contains either all integers or all doubles.
     * If the list contains other types of elements, an IllegalArgumentException will be thrown.
     */
    @Override
    public void sort() {
        String type = getType();
        if (type.equals("int")) { // sorting if array has all integers
            for (int i = size - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if ((int) arr[j] > (int) arr[j + 1]) {
                        swap(j, j + 1);
                    }
                }
            }
        } else if (type.equals("double")) { // sorting if array has all doubles
            for (int i = size - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if ((double) arr[j] > (double) arr[j + 1]) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }


    /**
     * Prints all elements in the list in order.
     */
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    /**
     * Determines the type of the elements in the list.
     * The type can be "int" if the list contains only integers, "double" if the list contains only doubles,
     * or an IllegalArgumentException will be thrown if the list contains other types of elements.
     *
     * @return the type of the elements in the list
     * @throws IllegalArgumentException if the list contains elements other than integers or doubles
     */
    private String getType() {
        boolean hasIntegers = true;
        boolean hasDoubles = true;
        for (int i = 0; i < size; i++) {
            if (!(arr[i] instanceof Integer)) {
                hasIntegers = false;
            }
            if (!(arr[i] instanceof Double)) {
                hasDoubles = false;
            }
        }
        if (hasIntegers) {
            return "int";
        } else if (hasDoubles) {
            return "double";
        } else {
            throw new IllegalArgumentException("Array must contain either all integers or all doubles.");
        }
    }
    /**
     * Swaps the elements at the two specified indices in the array.
     *
     * @param i the index of the first element to be swapped
     * @param j the index of the second element to be swapped
     */
    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}