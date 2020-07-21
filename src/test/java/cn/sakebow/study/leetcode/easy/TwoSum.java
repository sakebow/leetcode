package cn.sakebow.study.leetcode.easy;

import org.junit.jupiter.api.Test;

/**
 * 两个数的和达到规定，返回下标
 */
public class TwoSum {
    @Test
    public void test() {
        int[] result = twoSum(new int[] {1, 2, 3, 98, 88}, 100);
        for (int re : result) {
            System.out.println(re);
        }
    }

    private int[] twoSum(int[] nums, int target) {
        // init
        int[] result = {0, 0}; int length = nums.length;
        // rolling
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i; result[1] = j;
                    break;
                }
            }
        }
        // end
        return result;
    }
}
