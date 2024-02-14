import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArray myArray = new MyArray(10);
        myArray.fill();

        MyArray myArray2 = new MyArray(new int[] {5, 4, 3, 2, 1});
        MyArray myArray3 = new MyArray(15);
        MyArray myArray4 = myArray.clone();

        int[] arraySimple = {5, 4, 3, 2, 1};

        for(int i = 0; i < myArray2.getSize(); i++){
            myArray3.addLast(myArray2.get(i));
        }

        System.out.println(myArray.equals(myArray4));
        System.out.println(myArray.equals(myArray2));
        System.out.println(myArray2.equals(arraySimple));
        System.out.println(myArray2.equals((MyArray) null));

        printArray(myArray3);

        printArray(myArray);

        myArray.addLast(10);
        printArray(myArray);

        myArray.add(5,20);
        printArray(myArray);

        myArray.remove(6);
        printArray(myArray);

        myArray.resize(20);
        printArray(myArray);

    }

    public static void printArray(MyArray myArray){
        System.out.println(myArray);
        System.out.println(myArray.getSize());

    }
}