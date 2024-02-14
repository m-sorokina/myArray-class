import java.util.Arrays;

public class MyArray implements Cloneable{
    private int[] array;

//    private int size;

    public MyArray(int size) {
        array = new int[size];
    }

    public MyArray(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }


    public int getSize() {
        return array.length;
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
        return i >= 0 && i < array.length;
    }

    public void fill() {
        for (int i = 0; i < getSize(); i++) {
            set(i, i);
        }
    }

    public void resize(int size) {
        int[] array2 = new int[size];
        int newLength = (size < array.length) ? size : array.length;
        for (int i = 0; i < newLength; i++) {
            array2[i] = array[i];
        }
        this.array = array2;
    }

    public void addLast(int value) {
        resize(getSize() + 1);
        array[getSize() - 1] = value;
    }

    public void add(int index, int value) {
        if (!ifIndexExists(index)) {
            System.out.println("Index is out of bounds");
            return;
        }
        resize(getSize() + 1);
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
        resize(getSize() - 1);

    }

    public boolean equals(MyArray array){
        if (array == null) return false;
        return this.equals(array.array);
    }

    public boolean equals(int[] array){
        if (array == null) return false;
        if (array.length != getSize()) return false;
        for (int i = 0; i < getSize(); i++){
            if (array[i] != get(i)) return false;
        }
        return true;
    }


    @Override
    public MyArray clone() {
       return new MyArray(array);
    }

    public String toString() {
        return "The array is " + Arrays.toString(array);
    }


}
