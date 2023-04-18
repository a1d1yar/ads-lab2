
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
         if(size==arr.length){
           addArraySize();
         }
         arr[size++]= (T) item;
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
            return false;
        }

        @Override
        public Object remove(int index) {
            return null;
        }

        @Override
        public void clear() {

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
    }




