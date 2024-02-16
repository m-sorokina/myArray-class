import java.util.Arrays;

public class MyArray implements Cloneable {
    private int[] array;

    private int size;

    public MyArray() {
        this(0);
    }

    public MyArray(int size) {
        array = new int[size];
        this.size = size;
    }

    public MyArray(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
        this.size = array.length;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int value) {
        size = value;
    }

    public void set(int i, int value) {
        if (!ifIndexExists(i)) {
            System.out.println("Index is out of bounds");
            return;
        }
        array[i] = value;
    }

    public int get(int i) {
        if (!ifIndexExists(i)) {
            System.out.println("Index is out of bounds");
            return 0;
        }
        return array[i];
    }

    private boolean ifIndexExists(int i) {
        return i >= 0 && i < getSize();
    }

    public void fill() {
        for (int i = 0; i < getSize(); i++) {
            set(i, i);
        }
    }

    public void resize(int size) {
        int[] array2 = new int[size];
        int newLength = (size < getSize()) ? size : getSize();
        for (int i = 0; i < newLength; i++) {
            array2[i] = array[i];
        }
        array = array2;
        setSize(size);
    }

    private void checkDoubleSize() {
        if (getSize() == array.length) {
            int[] array2 = new int[getSize() * 2];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }
            array = array2;
        }
        setSize(getSize() + 1);
    }

    public void addLast(int value) {
        checkDoubleSize();
        array[getSize() - 1] = value;
    }

    public void add(int index, int value) {
        if (!ifIndexExists(index)) {
            System.out.println("Index is out of bounds");
            return;
        }
        checkDoubleSize();
        for (int i = getSize() - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public void remove(int index) {
        if (!ifIndexExists(index)) {
            System.out.println("Index is out of bounds");
            return;
        }
        for (int i = index; i < getSize() - 1; i++) {
            array[i] = array[i + 1];
        }
        setSize(getSize() - 1);

    }

    public boolean equals(MyArray array) {
        if (array == null) return false;
        return this.equals(array.array);
    }

    public boolean equals(int[] array) {
        if (array == null) return false;
        if (array.length != getSize()) return false;
        for (int i = 0; i < getSize(); i++) {
            if (array[i] != get(i)) return false;
        }
        return true;
    }

    @Override
    public MyArray clone() {
        return new MyArray(array);
    }

    public String toString() {
        return "The array is " + Arrays.toString(Arrays.copyOfRange(array, 0, getSize()));
    }

    public void sortSimple() {
        int[] arraySort = new int[getSize()];
        for (int i = 0; i < arraySort.length; i++) {
            arraySort[i] = getMin();
            array[indexOf(getMin())] = Integer.MAX_VALUE;
        }
        array = arraySort;
    }

    public void sortSelect() {
        for (int i = 0; i < getSize(); i++) {
            int index = getIndexOfMin(i);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    public int getMin() {
        int min = array[0];
        for (int i = 0; i < getSize(); i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public int getIndexOfMin(int i) {
        int minIndex = i;
        for (; i < getSize(); i++) {
            if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            return minIndex;
        }

        public int indexOf ( int value){
            for (int i = 0; i < getSize(); i++) {
                if (array[i] == value) return i;
            }
            return -1;
        }

    }
