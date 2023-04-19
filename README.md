# ads-lab 2
Maratov Aldiyar se-2217

# Mylist1
## addArraySize()
__Description:__
>Increases the capacity of the array by doubling its size.

_Code:_
```java
 public void addArraySize() {
        int i;
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (i = 0; i < size; i++) {
        newArr[i] = arr[i];
        }
        arr = newArr;
        }}
```

## size()
__Description:__
>Returns the number of elements in the list.


_Code:_
```java
public int size() {
        return size;
        }
```

## contains()
__Description:__
>Returns true if the list contains the specified element.

_Code:_
```java
public boolean contains(Object o) {
        boolean cont = false;
        int i;
        for (i = 0; i < size; i++) {
        if (arr[i] == o) cont = true;
        }

        return cont;
        }
```
## add(Object o)
__Description:__
>Adds the specified element to the end of the list.

_Code:_
```java
public void add(Object item) {
        if (size == arr.length) {
        addArraySize();
        }
        arr[size++] = (T) item;
        }
```
## add(Object o,int index)
__Description:__
>Inserts the specified element at the specified position in the list.

_Code:_
```java
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
```
## remove(Object item)
__Description:__
>Removes the first occurrence of the specified element from the list, if it is present.


_Code:_
```java
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
```
## remove(int index)
__Description:__
>Removes the element at the specified position in the list.

_Code:_
```java
public Object remove(int index) {
        checkIndex(index);
        int i ;
        for ( i = index + 1; i < size; i++) {
        arr[i - 1] = arr[i];
        }
        size--;
        return null;
        }
```
## clear()
__Description:__
>Removes all the elements from this list.

_Code:_
```java
public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
        }
```
## get()
__Description:__
>Returns the element at the specified position in this list.


_Code:_
```java
public Object get(int index) {
        checkIndex(index);
        return arr[index];
        }
```
## indexOf()
__Description:__
>Returns the index of the first occurrence of the specified element in this list,or -1 if this list does not contain the element.



_Code:_
```java
public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
```
## lastIndexOf()
__Description:__
>Returns the index of the last occurrence of the specified element in this list,or -1 if this list does not contain the element.

_Code:_
```java
public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--) {
        if(arr[i].equals(o)) {
        return i;
        }
        }
        return -1;
        }
```
## checkIndex()
__Description:__
>Checks if the given index is within the bounds of the list.Throws an IndexOutOfBoundsException if the index is out of bounds.


_Code:_
```java
 public void checkIndex(int index) {
        if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException();
        }
        }
```
## sort()
__Description:__
>Sorts the elements in the list in ascending order.This method only works if the list contains either all integers or all doubles. If the list contains other types of elements, an IllegalArgumentException will be thrown.


_Code:_
```java
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
```
## printList()
__Description:__
>Prints all elements in the list in order.

```java
 public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
```
## getType()
__Description:__
>Determines the type of the elements in the list. The type can be "int" if the list contains only integers, "double" if the list contains only doubles, or an IllegalArgumentException will be thrown if the list contains other types of elements.

 _Code:_
```java
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
```
## swap()
__Description:__
>Swaps the elements at the two specified indices in the array.

```java
private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
```

 
# LinkedList
   
## size()
__Description:__
>returning size of linked list.

```java
public int size() {
        return size;
    }
```
## isEmpty()
__Description:__
>checking is linked list empty or not

_Code:_
```java
public boolean isEmpty() {
        return head == null;
        }
```

## printlist()
__Description:__
>Prints the elements of the linked list to the console.


_Code:_
```java
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
```

## contains()
__Description:__
>Checks if the list contains the specified element.

_Code:_
```java
public boolean contains(Object o) {
        Node<T> ptr = head;
        while (ptr != null) {
        if (o.equals(ptr.val)) {
        return true;
        }
        ptr = ptr.next;
        }
        return false;
```
## add(Object o)
__Description:__
>Adds the specified element to the end of this list.

_Code:_
```java
ppublic void add(Object item) {
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
```
## add(Object o,int index)
__Description:__
>Inserts the specified element at the specified position in this list.
Shifts the element currently at that position (if any) and any subsequent
elements to the right (adds one to their indices).

_Code:_
```java
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
```
## getNode()
__Description:__
>Returns the node at the specified index in this LinkedList.

_Code:_
```java
  private Node<T> getNode(int index) {
        Node<T> ptr = head;
        for (int i = 0; i < index; i++) {
        ptr = ptr.next;
        }
        return ptr;
        }
```
## remove(Object item)
__Description:__
>Removes the first occurrence of the specified object from the list, if it is present.
_Code:_
```java
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
```
## remove(int index)
__Description:__
>Removes the node at the specified index from the list.

_Code:_
```java
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
```
## clear()
__Description:__
>Removes all elements from this LinkedList.

_Code:_
```java
 public void clear() {
        head = null;
        tail = null;
        size = 0;
        }
```
## get()
__Description:__
>Retrieves the element at the specified index in this list.


_Code:_
```java
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
```
## indexOf()
__Description:__
>Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
_Code:_
```java
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
```
## lastIndexOf()
__Description:__
>Returns the index of the last occurrence of the specified object in this list.

_Code:_
```java
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
```
## sort()
__Description:__
>orts the elements of this LinkedList in ascending order.

_Code:_
```java
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
```
## checkIndex()
__Description:__
>Checks if the given index is within the bounds of the LinkedList.

_Code:_
```java
 public void checkIndex(int index){
        if(index<0||index>size){
        throw new IndexOutOfBoundsException();
        }
        }
```
## swapValues()
__Description:__
>Swaps the elements at the specified indices in this list.

_Code:_
```java
 public void swapValues(Node<T> first, Node<T> second) {
        T value = first.val;
        first.val = second.val;
        second.val = value;
        }
```
## isSortable()
__Description:__
> Returns a boolean indicating if this LinkedList can be sorted using the sort method.
```java
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
```
