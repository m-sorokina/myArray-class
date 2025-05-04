import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


public class TestMyArray {

    @Test
    public void testMyArrayObjEquals() {

        MyArray array = new MyArray(new int[] {1, 2, 3, 4, 5});
        MyArray arrayExpectedTrue = new MyArray(new int[] {1, 2, 3, 4, 5});
        MyArray arrayExpectedFalse = new MyArray(new int[] {5, 4, 3, 2, 1});

        Assertions.assertTrue(array.equals(arrayExpectedTrue), "array should be equal to arrayExpectedTrue");
        Assertions.assertFalse(array.equals(arrayExpectedFalse), "array should not be equal to arrayExpectedFalse");
        Assertions.assertFalse(array.equals((MyArray) null), "array should not be equal null");

    }

    @Test
    public void testArrayObjEquals() {

        MyArray array = new MyArray(new int[] {1, 2, 3, 4, 5});
        int[] arrayExpectedTrue = {1, 2, 3, 4, 5};
        int[] arrayExpectedFalse = {1, 2, 3, 4};

        Assertions.assertTrue(array.equals(arrayExpectedTrue), "array should be equal to arrayExpectedTrue");
        Assertions.assertFalse(array.equals(arrayExpectedFalse), "array should not be equal to arrayExpectedFalse");
        Assertions.assertFalse(array.equals((int[]) null), "array should not be equal null");

    }

    @Test
    public void testToArray(){
        MyArray array = new MyArray(new int[] {1, 2, 3, 4, 5});
        int[] arrayExpected = {1, 2, 3, 4, 5};

        Assertions.assertArrayEquals(arrayExpected,array.toArray(), "array should be equal to arrayExpected");
    }

    static Stream<Object[]> provideTestData() {
        return Stream.of(
                new Object[]{new MyArray(new int[] {1, 2, 3, 4, 5}), false},
                new Object[]{new MyArray(new int[] {5, 4, 3, 2, 1}), true}
        );
    }
    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSortByDesc(MyArray arrayExpected, boolean isDesc) {
        MyArray arraySort = new MyArray(new int[] {4, 3, 1, 5, 2});
        arraySort.sort(isDesc);
        Assertions.assertArrayEquals(arrayExpected.toArray(), arraySort.toArray(), "arraySort should be equal to arrayExpected after sorting");
        arraySort.sort(isDesc);
        Assertions.assertArrayEquals(arrayExpected.toArray(), arraySort.toArray(), "arraySort should be equal to arrayExpected after sorting");

    }

    @Test
    public void testResize() {
        MyArray array = new MyArray(new int[] {1, 2, 3, 4, 5});
        MyArray arrayExpectedPlus = new MyArray(new int[] {1, 2, 3, 4, 5, 0, 0});
        MyArray arrayExpectedMinus = new MyArray(new int[] {1, 2, 3, 4});
        array.resize(7);
        Assertions.assertTrue(array.equals(arrayExpectedPlus), "array should be equal to arrayExpectedPlus");
        array.resize(4);
        Assertions.assertTrue(array.equals(arrayExpectedMinus), "array should be equal to arrayExpectedMinus");
        array.resize(0);
        Assertions.assertTrue(array.equals(new MyArray()), "array should be equal to new MyArray()");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            array.resize(-2);
        }, "Resize should throw IllegalAccessException");

    }

@Test
    public void testSortSimple() {
        MyArray arraySort = new MyArray(new int[] {1, 4, 3, 5, 2});
        MyArray arrayExpected = new MyArray(new int[] {1, 2, 3, 4, 5});
        arraySort.sortSimple();
        Assertions.assertArrayEquals(arrayExpected.toArray(), arraySort.toArray(), "arraySort should be equal to arrayExpected after sorting");
    }
}
