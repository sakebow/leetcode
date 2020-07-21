package cn.sakebow.study.leetcode.easy;

import org.junit.jupiter.api.Test;

/**
 * 反转整数
 * 0 - 大于及其允许的最大、小于机器允许的最小都不可以
 * 1 - 在允许范围内时，原数字从尾到头不停退，新数字从头到尾不停进
 * 2 - 在最后一位的时候如果大于 最大/10、小于 最小/10 都是不行的
 */
public class IntegerReverse {
    @Test
    public void test() {
        System.out.println(reverse(123));
    }

    private int reverse(int x) {
        // 0 - 大于机器允许的最大、小于机器允许的最小都不可以
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        // 1 - 在允许范围内时，原数字从尾到头不停退，新数字从头到尾不停进
        int flag = x < 0 ? -1 : 1, y = x * flag, z = 0;
        while (y / 10 != 0) {
            z = z * 10 + y % 10;
            y /= 10;
        }
        z = z * flag;
        // 2 - 在最后一位的时候如果大于 最大/10、小于 最小/10 都是不行的
        if (z  > Integer.MAX_VALUE / 10 || z < Integer.MIN_VALUE / 10) {
            return 0;
        }
        // 3 - 检测通过就加上最后剩下的尾巴
        return z * 10 + y * flag;
    }
}
