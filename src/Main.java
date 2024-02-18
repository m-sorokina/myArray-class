import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArray myArray = new MyArray(10);
        myArray.fill();

        MyArray myArray2 = new MyArray(new int[] {5, 4, 3, 2, 1});
        MyArray myArray3 = new MyArray(15);
        MyArray myArray4 = myArray.clone();
        MyArray myArray5 = new MyArray(new int[] {10, 11, 5, 6, 0, 21, 36, 5, 19, 19, 3, 28, 21});
        MyArray myArray6 = new MyArray(new int[] {10, 11, 5, 6, 0, 21, 36, 5, 19, 19, 3, 28, 21});
        MyArray myArray7 = new MyArray(new int[] {10, 11, 5, 6, 0, 21, 36, 5, 19, 19, 3, 28, 21});
        MyArray myArray8 = new MyArray(new int[] {10, 11, 5, 6, 0, 21, 36, 5, 19, 19, 3, 28, 21});

        int[] arraySimple = {5, 4, 3, 2, 1, 1, 25, 43, 29};

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

        myArray3.sortSimple();
        printArray(myArray3);

//        myArray5.sortSimple();
        printArray(myArray5);
        myArray5.sortSelect();
        printArray(myArray5);

        printArray(myArray6);
        myArray6.sortSimpleR(0);
        printArray(myArray6);

        printArray(myArray7);
        myArray7.sortInsert();
        printArray(myArray7);

        printArray(myArray8);
        myArray8.sortBubble();
        printArray(myArray8);

        int value = 28;
        int index = myArray8.binarySearch(value);
        if (index == -1){
            System.out.println("Index was not found");
        } else {
            System.out.println(index);
        }





    }

    public static void printArray(MyArray myArray){
        System.out.println(myArray);
        System.out.println(myArray.getSize());

    }
}