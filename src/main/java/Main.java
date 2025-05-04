import java.util.Arrays;
import java.util.List;

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
        MyArray myArray9 = new MyArray(new int[] {10, 11, 5, 6, 19, 21, 36, 5, 19, 0, 3, 28, 21});


        int[] arraySimple = {5, 4, 3, 2, 1, 1, 25, 43, 29};

        for(int i = 0; i < myArray2.getSize(); i++){
            myArray3.addLast(myArray2.get(i));
        }
        System.out.println("Comparing two MyArray objects for equality");
        printArray(myArray, "myArray");
        printArray(myArray4, "myArray4");
        System.out.println("The result is " + myArray.equals(myArray4));
        
        System.out.println();

        printArray(myArray, "myArray");
        printArray(myArray2, "myArray2");
        System.out.println("The result is " + myArray.equals(myArray2));
        
        System.out.println();

        System.out.println("Comparing an object of MyArray with Array object for equality");
        printArray(myArray2, "myArray2");
        System.out.println("arraySimple: \t" + Arrays.toString(arraySimple));
        System.out.println("The result is " + myArray2.equals(arraySimple));
        
        System.out.println();

        System.out.println("Comparing an object of MyArray with null");
        printArray(myArray2, "myArray2");
        System.out.println("The result is " + myArray2.equals((MyArray) null));
        
        System.out.println();

        System.out.println("Copying of MyArray objects");
        System.out.println("Copying myArray9 from index 0 to the given length:");
        printArray(myArray9.copyOf(5), "myArray9(copy) ");

        System.out.println();

        try {
            System.out.println("Attempting to copy myArray9 with invalid indices: from = 35, to = 5");
            printArray(myArray9.copyOf(35, 5), "myArray9");
        }
        catch (Exception e){
            System.out.printf("Error = 'From' index is greater than 'To' %s%n", e.getMessage());
        }

        System.out.println();

        System.out.println("Performing different operations on MyArray object");

        printArray(myArray, "myArray");

        System.out.println("Add 10 to the end of myArray:");
        myArray.addLast(10);
        printArray(myArray, "myArray");

        System.out.println("Insert 20 at index 5 in myArray:");
        myArray.add(5,20);
        printArray(myArray, "myArray");

        System.out.println("Remove element at index 6 from myArray:");
        myArray.remove(6);
        printArray(myArray, "myArray");

        System.out.println("Resize myArray to size 20 and -2:");
        try {
            myArray.resize(20);
            printArray(myArray, "myArray");
            myArray.resize(-2);
            printArray(myArray, "myArray");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();


        System.out.println("Sorting MyArray objects using different sort algorithms");
        System.out.println("Sort myArray9 by descending order:");
        printArray(myArray9, "myArray9");
        myArray9.sort(true);
        printArray(myArray9, "myArray9");

        System.out.println();

        printArray(myArray3, "myArray3");
        System.out.println("Sort myArray3 using simple sort:");
        myArray3.sortSimple();
        printArray(myArray3, "myArray3");

        System.out.println();

        printArray(myArray5, "myArray5");
        System.out.println("Sort myArray5 using selection sort:");
        myArray5.sortSelect();
        printArray(myArray5, "myArray5");

        System.out.println();

        printArray(myArray6, "myArray6");
        System.out.println("Sort myArray6 using simple recursive sort:");
        myArray6.sortSimpleR(0);
        printArray(myArray6, "myArray6");

        System.out.println();

        printArray(myArray7, "myArray7");
        System.out.println("Sort myArray7 using insertion sort:");
        myArray7.sortInsert();
        printArray(myArray7, "myArray7");

        System.out.println();

        printArray(myArray8, "myArray8");
        System.out.println("Sort myArray8 using bubble sort:");
        myArray8.sortBubble();
        printArray(myArray8, "myArray8");

        System.out.println();

        System.out.println("Performing binary search for value 0 in myArray8:");
        printArray(myArray8, "myArray8");
        int value = 0;
        int index = myArray8.binarySearch(value);
        if (index == -1){
            System.out.println("Index was not found");
        } else {
            System.out.println("Index found: " + index);
        }

        System.out.println();

        System.out.println("Performing index search for value 0 in myArray9:");
        printArray(myArray9, "myArray9");
        List<Integer> arrayIndex = myArray9.indexSearch(value);
        if (arrayIndex.isEmpty()){
            System.out.println("Index was not found");
        } else {
            System.out.println("Indices found: " + arrayIndex);
        }

        System.out.println();
    }

    public static void printArray(MyArray myArray, String arrayName){
        System.out.printf("%s(%d): \t%s%n", arrayName,myArray.getSize(),myArray);
    }

}
