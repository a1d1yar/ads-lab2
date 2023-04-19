public class MyList1<T> implements MyList {
    private T[] arr;
    private int size;
    public MyList1() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    public void addArraySize(){
        int i;
        T[] newArr = (T[]) new Object[arr.length*2];
        for (i=0; i<size; i++){
            newArr[i]=arr[i];
        }
        arr=newArr;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(Object o) {
        boolean cont=false;
        int i;
        for(i=0; i<size; i++){
            if (arr[i]==o) cont = true;
        }

        return cont;
    }
    @Override
    public void add(Object item) {
        if(size == arr.length){
            addArraySize();
        }
        arr[size++] = (T) item;
    }
    @Override
    public void add(Object item, int index) {
        int i;
        if (size == arr.length) {
            addArraySize();
        }
        T[] newArr = (T[]) new Object[arr.length];

        for (i = 0; i < index; i++) newArr[i] = arr[i];
        for (i=0;i<size;i++){
            newArr[i+1] = arr[i];
        }
    }
    @Override
    public boolean remove(Object item) {
        boolean rem=false;
        int i;
        for(i=0; i<size; i++){
            if(arr[i]==item){
                remove(i);
            }
        }
        return rem;
    }
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
    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }
    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(arr[i]==o){
                return i;
            }
        }
        return -777;
    }
    @Override
    public int lastIndexOf(Object o) {
        for(int i=size-1;i >= 0;i--){
            if(arr[i]==o){
                return i;
            }
        }
        return -777;
    }
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
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



    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

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

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}