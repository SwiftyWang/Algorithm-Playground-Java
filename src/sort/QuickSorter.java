package sort;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class QuickSorter implements Sorter<Integer> {

    @Override
    public Integer[] sort(Integer[] nums) {
        String ret = Arrays.toString(nums);
        //System.out.println(ret);
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == mid) {
                continue;
            }
            if (nums[i] <= nums[mid]) {
                left.push(nums[i]);
            } else {
                right.push(nums[i]);
            }
        }
        Integer[] leftArray = left.toArray(new Integer[]{});
        Integer[] rightArray = right.toArray(new Integer[]{});
        return concat(sort(leftArray), concat(new Integer[]{nums[mid]}, sort(rightArray)));
    }

    private Integer[] concat(Integer[] a1, Integer[] a2) {
        Stream<Integer> stream1 = Stream.of(a1);
        Stream<Integer> stream2 = Stream.of(a2);
        Stream<Integer> stream = Stream.concat(stream1, stream2);
        return stream.toArray(Integer[]::new);
    }
}
