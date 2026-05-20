//https://leetcode.com/problems/two-sum/description/
// @author: Crisdcs

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class twoSum{
    public int[] twoSumOp(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        twoSum s = new twoSum();
        int[] res = s.twoSumOp(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(res));
    }
}
