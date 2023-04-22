import java.util.Random;
public class Methods {
    public static void main(String args[]) {
        // testToCharArray();
        // testMax();
        // testToString();
        // testIndexOf();
        // testFactorial();
        // testisLeapYear();
        // testPrintIneteger();
        // testSort();
        // testFindOfDuplicates();
        // testMultiply();
        // testDistinctive();
        // testReverse();
        // testGenerateRandom();
        // testIsFindMatch();
        // testSumDiagonals();
        // testChecking();
        // testChars();
    }
    static void testChars() {
        char[][] array = new char[2][2];
        array[0][0] = 'V';
        array[0][1] = 'W';
        array[1][0] = 'V';
        array[1][1] = 'W';
        printSymbols(array);
    }
    static void testChecking() {
        int[] expected = {1, 3, 5, 6, 7};
        int[][] first = new int[3][3];
        first[0][0] = 1;
        first[0][1] = 2;
        first[0][2] = 3;
        first[1][0] = 4;
        first[1][1] = 5;
        first[1][2] = 6;
        first[2][0] = 7;
        first[2][1] = 8;
        first[2][2] = 9;

        boolean[][] second = new boolean[3][3];
        second[0][0] = true;
        second[0][1] = false;
        second[0][2] = true;
        second[1][0] = false;
        second[1][1] = true;
        second[1][2] = true;
        second[2][0] = true;
        second[2][1] = false;
        second[2][2] = false;

        int[] actual = new int[expected.length];
        actual = checking(first,second);

        testIdentityComparerOfIntArrays("#22",expected,actual);
    }
    static void testSumDiagonals() {
        int expected = 30;
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[1][0] = 4;
        array[1][1] = 5;
        array[1][2] = 6;
        array[2][0] = 7;
        array[2][1] = 8;
        array[2][2] = 9;
        int result = 0;
        result = sumDiagonals(array);
        integerEquals("#20",expected,result);
    }
    static void testIsFindMatch() {
        char[] first = {'A','R','r','A','Y'};
        char[] second = {'R','r'};
        boolean expected = true;
        boolean actual = isFindMatch(first,second);
        booleanEquals("#19",expected,actual);
    }
    static void testGenerateRandom() {
        boolean expected = true;
        boolean boolActual = false;
        int[] actual = new int[6];
        actual = generateRandom(6, 2, 4);
        if(actual.length == actual.length) {
            boolActual = true;
        }
        booleanEquals("#18",boolActual,expected);
    }
    static void testReverse() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        int[] actual = new int[expected.length];
        actual = reverse(array);
        testIdentityComparerOfIntArrays("#17", expected, actual);
    }
    static void testDistinctive() {
        int[] first = {2, 2, 1, 5, 5};
        int[] second = {3, 3, 1, 2, 2, 7, 9};
        int[] expectedFirst = {1, 2, 5};
        int[] expectedSecond = {1, 2, 3, 7, 9};
        int[] expectedResult = {5, 3, 7, 9};
        int[] actualFirst = new int[expectedFirst.length];
        int[] actualSecond = new int[expectedSecond.length];
        int[] actualResult = new int[expectedResult.length];
        actualFirst = sort(first);
        actualSecond = sort(second);
        actualFirst = removeDublicates(actualFirst);
        actualSecond = removeDublicates(actualSecond);
        actualResult = distinctive(actualFirst, actualSecond);
        testIdentityComparerOfIntArrays("#16",expectedResult,actualResult);
    }
    static void testMultiply() {
        int[] first = {1, 2, 3,};
        int[] second = {4, 5, 6};
        int[] expected = {4, 10, 18};
        int[] actual = new int[expected.length];
        actual = multiply(first, second);
        testIdentityComparerOfIntArrays("#15", expected, actual);
    }
    static void testFindOfDuplicates() {
        byte[] array = {1, 3, 4, 5, 3};
        boolean expected = true;
        boolean actual = findOfDuplicates(array);
        booleanEquals("#14", expected, actual);
    }
    static void testToCharArray() {
        int[] array = {1, 4, 5, 6, 2};
        char[] expectedArray = {1, 4, 5, 6, 2};
        char[] actualArray = new char[array.length];
        actualArray = toCharArray(array);
        testIdentityComparerOfCharsArrays("#2", expectedArray, actualArray);
    }
    static void testSort() {
        int[] array = {2, 1, 3, 5, 4, 3, 3};
        int[] expected = {1, 2, 3, 3, 3, 4, 5};
        int[] actual = new int[array.length];
        actual = sort(array);
        testIdentityComparerOfIntArrays("#13", expected, actual);
    }
    static void testMax() {
        int expected = 4;
        int actual = max(1, 2, 3, 4, 2);
        integerEquals("#3-5", expected, actual);
    }
    static void testToString() {
        String expected = "abc";
        char[] array = {'a', 'b', 'c'};
        String actual = toString(array);
        stringEquals("#6", expected, actual);
    }
    static void testIndexOf() {
        int value = 8;
        int[] array = {1, 10, 5, 8, 6};
        int expected = 3;
        int actual = indexOf(array, value);
        integerEquals("#8", expected, actual);

        value = 11;
        expected = -1;
        actual = indexOf(array, value);
        integerEquals("#8.1", expected, actual);

        value = 1;
        expected = 0;
        actual = indexOfFromEnd(array, value);
        integerEquals("#9", expected, actual);

        value = 11;
        expected = -1;
        actual = indexOfFromEnd(array, value);
        integerEquals("#9.1", expected, actual);
    }
    static void testFactorial() {
        int expected = 120;
        int actual = factorial(5);
        integerEquals("#10", expected, actual);
    }
    static void testisLeapYear() {
        boolean expected = false;
        boolean actual = isLeapYear(1913);
        booleanEquals("#11.1", expected, actual);
        expected = true;
        actual = isLeapYear(2000);
        booleanEquals("#11.2", expected, actual);
    }
    static void booleanEquals(String testId, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println("TEST " + testId + " PASSED!");
        } else {
            System.out.println("TEST " + testId + " FAULD. Mistake: expected " + expected + ", actual: " + actual);
        }
    }
    static void integerEquals(String testId, int expected, int actual) {
        if (expected == actual) {
            System.out.println("TEST " + testId + " PASSED!");
        } else {
            System.out.println("TEST " + testId + " FAULD. Mistake: expected " + expected + ", actual: " + actual);
        }
    }
    static void stringEquals(String testId, String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST " + testId + " PASSED!");
        } else {
            System.out.println("TEST " + testId + " FAULD. Mistake: expected '" + expected + "', actual: '" + actual + "'");
        }
    }
    static void testIdentityComparerOfCharsArrays(String testId, char[] expectedArray, char[] actualArray) {
        for (int i = 0; i < expectedArray.length; i++) {
            if (actualArray[i] != expectedArray[i]) {
                System.out.println("TEST " + testId + " FAULD. Mistake: expected '" + expectedArray[i] + "', actual: '" + actualArray[i] + "'");
                break;
            }
            if (i == expectedArray.length - 1) {
                System.out.println("TEST " + testId + " PASSED!");
            }
        }
    }
    static void testIdentityComparerOfIntArrays(String testId, int[] expectedArray, int[] actualArray) {
        boolean stopper = false;
        for (int i = 0; i < expectedArray.length - 1; i++) {
            if (actualArray[i] != expectedArray[i]) {
                stopper = true;
                System.out.println("TEST " + testId + " FAULD. Mistake: expected '" + expectedArray[i] + "', actual: '" + actualArray[i] + "'");
                break;
            }
        }
        if (stopper == false) {
            System.out.println("TEST " + testId + " PASSED!");
        }
    }
    static char[] toCharArray(int[] array) {//#2
        char[] charArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            charArray[i] = (char) array[i];
        }
        return charArray;
    }
    static void testPrintIneteger() {
        int[] array = {5, 4, 9, 2, 8};
        printInteger(array, 2);
    }
    static void printer(int[] array, String message) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("] " + message);
    }
    static int max(int a, int b) {//#3
        return a < b ? b : a;
    }
    static int max(int a, int b, int c) {//#4
        return max(max(a, b), c);
    }
    static int max(int a, int b, int c, int d, int e) {//#5
        return max(max(a, b), max(c, d), e);
    }
    static String toString(char[] array) {//#6
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
        }
        return string;
    }
    static int indexOf(int[] array, int value) {//#8
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    static int indexOfFromEnd(int[] array, int value) {//#9
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    static int factorial(int value) {//#10
        int result = 1;
        for (int i = 2; i <= value; i++) {
            result = result * i;
        }
        return result;
    }
    static boolean isLeapYear(int year) {//#11
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? true : false;
    }
    static void printInteger(int[] array, int value) {//12
        for (int i = 0; i < array.length; i++) {
            if (array[i] % value == 0) {
                //System.out.println(array[i]);
            }
        }
    }
    static int[] sort(int[] array) {//13
        int value = 0;
        int counter = 1;
        while(counter != 0) {
            counter = 0;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]) {
                    value = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = value;
                    counter++;
                }
            }
        }
        return array;
    }
    static int[] removeDublicates(int[] array) {//16.1
        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                counter++;
            }
        }
        int index = array.length - counter;
        int[] result = new int[index];
        counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                    result[counter] = array[i];
                    counter++;
            }
            if(i == array.length - 2) {
                if(array[i] == array[i + 1]) {
                    result[counter] = array[i];
                    counter++;
                }
                if(array[i] != array[i + 1]) {
                    result[counter] = array[i + 1];
                    counter++;
                }
            }
        }
        return result;
    }
    static boolean findOfDuplicates(byte[] array) {//14
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    static int[] multiply(int[] first, int[] second) {//15
        int[] result = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            result[i] = first[i] * second[i];
        }
        return result;
    }
    static int[] distinctive(int[] first, int[] second) {//16
        int counter = 0;
        int index = 0;
        boolean bool = false;
        for (int i = 0; i <= first.length - 1; i++) {
            for (int j = 0; j < second.length - 1; j++) {
                if(first[i] == second[j]) {
                    bool = true;
                    break;
                }
            }
            if(bool == false) {
                counter++;
            }
            bool = false;
        }
        for (int i = 0; i <= second.length - 1; i++) {
            for (int j = 0; j <= first.length - 1; j++) {
                if(second[i] == first[j]) {
                    bool = true;
                    break;
                }
            }
            if(bool == false) {
                counter++;
            }
            bool = false;
        }
        int[] result = new int[counter];
        for (int i = 0; i <= first.length - 1; i++) {
            for (int j = 0; j < second.length - 1; j++) {
                if(first[i] == second[j]) {
                    bool = true;
                    break;
                }
            }
            if(bool == false) {
                result[index] = first[i];
                index++;
            }
            bool = false;
        }
        for (int i = 0; i <= second.length - 1; i++) {
            for (int j = 0; j <= first.length - 1; j++) {
                if(second[i] == first[j]) {
                    bool = true;
                    break;
                }
            }
            if(bool == false) {
                result[index] = second[i];
                index++;
            }
            bool = false;
        }
        return result;
    }
    static int[] reverse(int[] array) {//17
        int value = 0;
        int index = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            if(i != index) {
                value = array[index];
                array[index] = array[i];
                array[i] = value;
                index--;
            }
            else break;
        }
        return array;
    }
    static int[] generateRandom(int arrayLength, int lowerBound, int upperBound) {//18
        int[] result = new int[arrayLength];
        Random random = new Random();
        for(int i = 0; i < result.length; i++) {
                result[i] = random.nextInt(lowerBound) + upperBound;
        }
        return result;
    }
    static boolean isFindMatch(char[] first, char[] second) {//19
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(first[i] == second[j]) {
                    if (first[i + 1] == second[j + 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static int sumDiagonals(int[][] array) {
        int result = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i][index];
            index++;
            }
        index = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            result += array[i][index];
            index--;
        }
        return result;
    }
    static int[] checking (int[][] first, boolean second[][]) {
        int counter = 0;
        int index = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(second[i][j] == true) {
                    counter++;
                }
            }
        }
        int[] result = new int[counter];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(second[i][j] == true) {
                    result[index] = first[i][j];
                    index++;
                }
            }
        }
        return result;
    }
    static void printSymbols(char array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
