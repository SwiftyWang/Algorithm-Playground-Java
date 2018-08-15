package sort;

import java.util.Arrays;

public class TestSort {
    private static final Integer[] test1 = new Integer[]{6, 4, 2, 10, 16, 13, 20, 50, 32, 1};
    private static final Integer[] test2 = new Integer[]{35, 28, 43, 49, 1, 15, 68, 64, 70, 34, 13, 80, 85, 56, 52, 79, 8, 22, 95};

    public static void main(String[] args) {

        Sorter<Integer> sorter = null;
        Integer[] res = null;
        String ret = null;

        long start, end;
        // bubble sorter
        start = System.currentTimeMillis();
        sorter = new BubbleSorter();
        res = sorter.sort(test1);
        ret = Arrays.toString(res);
        System.out.println("Bubble Result1:" + ret);

        res = sorter.sort(test2);
        ret = Arrays.toString(res);
        System.out.println("Bubble Result2:" + ret);

        end = System.currentTimeMillis();
        System.out.println("Bubble spend time:" + (end - start));

        // quick sorter
        start = System.currentTimeMillis();
        sorter = new QuickSorter();
        res = sorter.sort(test1);
        ret = Arrays.toString(res);
        System.out.println("Quick Result1 :" + ret);

        res = sorter.sort(test2);
        ret = Arrays.toString(res);
        System.out.println("Quick Result2 :" + ret);

        end = System.currentTimeMillis();
        System.out.println("Quick spend time:" + (end - start));

        // quick sorter2
        start = System.currentTimeMillis();
        sorter = new QuickSorter2();
        res = sorter.sort(test1);
        ret = Arrays.toString(res);
        System.out.println("Quick2 Result1:" + ret);

        res = sorter.sort(test2);
        ret = Arrays.toString(res);
        System.out.println("Quick2 Result2:" + ret);

        end = System.currentTimeMillis();
        System.out.println("Quick2 spend time:" + (end - start));
    }
}
