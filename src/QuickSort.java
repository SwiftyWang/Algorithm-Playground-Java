import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 2, 10, 16, 13, 20, 50, 32, 1};
        Integer[] res = quickSort(nums);
        String ret = Arrays.toString(res);
        System.out.println("Result:" + ret);
    }

    private static Integer[] quickSort(Integer[] nums) {
        String ret = Arrays.toString(nums);
        System.out.println(ret);
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
        return concat(quickSort(leftArray), concat(new Integer[]{nums[mid]}, quickSort(rightArray)));
    }

    public static Integer[] concat(Integer[] a1, Integer[] a2) {
        Stream<Integer> stream1 = Stream.of(a1);
        Stream<Integer> stream2 = Stream.of(a2);
        Stream<Integer> stream = Stream.concat(stream1, stream2);
        return stream.toArray(Integer[]::new);
    }
}
