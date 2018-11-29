public class Team22SortCompetition {

    public static void main(String[]args)
    {
        int[] challengeOne = generateIntArr(10000,10000);
        long start = System.nanoTime();
        insertionSort(challengeOne);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println(time);
        System.out.println("ChallengeOne took " + (time / 1000) + " Microseconds");
        System.out.println("Sorted Int Array \n" + java.util.Arrays.toString(challengeOne));
        System.out.println("Median of ChallengeOne: " +getSortedMedian(challengeOne));
    }


    public static int getSortedMedian(int[] array) {
        int length = array.length;
        if (length % 2 == 0) {
            int medPos = length / 2;
            return array[medPos];
        } else {
            int medPos = length / 2;
            int medPos2 = length / 2 - 1;
            return (array[medPos] + array[medPos2]) / 2;
        }
    }

    public static void swapDouble(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * This is the same method as above but swapCount 2 String
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swapArr(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * this method generates a random array of int from the given param count and range
     *
     * @param count
     * @return
     */
    public static int[] generateIntArr(int count, int range) {
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    /**
     * This method generates a random array of doubles with the param count and range
     *
     * @param count
     * @param range
     * @return
     */
    public static double[] generateDoubleArr(int count, int range) {
        double[] arr = new double[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * range;
        }
        return arr;
    }

    public static String[] randomStringArr(int count, int range) {
        String[] arr = new String[count];
        while (count > 0) {
            int i = 0;
            String s = "";
            while (i < range) {
                char c = (char) ((Math.random() * 26) + 97);
                s = s + c;
                i++;
            }
            count--;
            arr[count] = s;
        }
        return arr;
    }

    /**
     * The insertion takes each element from the array, and adds it to the front of the array in the correct order.
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > index) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = index;
        }
    }

    /**
     * The selection sort compares 2 and if one is less than the other it will be moved to the front
     *
     * @param arr
     */
    public static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    swapDouble(arr, i, j);
                }
            }
        }
    }

    /**
     * Bubble sort compares 2 items and if the compareTo method compares the first letter and if its out of order they swap.
     *
     * @param arr
     */
    public static void bubbleSort(String[] arr) {
        int swapCount = 1;
        while (swapCount != 0) {
            swapCount = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swapArr(arr, i, i + 1);
                    swapCount++;
                }
            }
        }
    }

    public static void mergeSort(int[] elements) {
        int n = elements.length;
        int[] temp = new int[n];
        mergeSortHelper(elements, 0, n - 1, temp);
    }

    /**
     * Sort an array of integers into ascending order.
     *
     * @param elements an array containing the items to be sorted.
     *                 <p>
     *                 Postcondition: elements contains its original items and items in elements
     *                 are sorted in ascending order.
     */
    private static void mergeSortHelper(int[] elements, int from, int to, int[] temp) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeSortHelper(elements, from, middle, temp);
            mergeSortHelper(elements, middle + 1, to, temp);
            merge(elements, from, middle, to, temp);
        }
    }

    /**
     * This method takes 2 arrays that have already been sorted and compares the first items, compare and copies them to the temp araay
     * Temp array gets copied back eventually.
     *
     * @param elements
     * @param from
     * @param mid
     * @param to
     * @param temp     Sorts elements[from] ... elements[to] inclusive into ascending order.
     * @param elements an array containing the items to be sorted.
     * @param from     the beginning index of the items in elements to be sorted.
     * @param to       the ending index of the items in elements to be sorted.
     * @param temp     a temporary array to use during the merge process.
     *                 <p>
     *                 Precondition:
     *                 (elements.length == 0 or
     *                 0 <= from <= to <= elements.length) and
     *                 elements.length == temp.length
     *                 Postcondition: elements contains its original items and the items in elements
     *                 [from] ... <= elements[to] are sorted in ascending order.
     */
    private static void merge(int[] elements, int from, int mid, int to, int[] temp) {
        int a = from;
        int b = mid + 1;
        int c = from;

        while (a <= mid && b <= to) {
            if (elements[a] < elements[b]) {
                temp[c] = elements[a];
                a++;
            } else {
                temp[c] = elements[b];
                b++;
            }
            c++;
        }
        while (a <= mid) {
            temp[c] = elements[a];
            a++;
            c++;
        }
        while (b <= to) {
            temp[c] = elements[b];
            b++;
            c++;
        }
        for (c = from; c <= to; c++) {
            elements[c] = temp[c];
        }
    }
}
