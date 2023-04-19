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
