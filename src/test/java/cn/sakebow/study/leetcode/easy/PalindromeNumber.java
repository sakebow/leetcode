package cn.sakebow.study.leetcode.easy;

import org.junit.jupiter.api.Test;

/**
 * 检测输入是否是回文数
 * 0 - 负数绝对不是回文数
 * 1 - 将数字分为两段，一段从后往前退，一段从前往后进，直到前一段小于等于后一段为止
 * 2 - 如果前一段等于后一段，说明这个数字一共偶数个，并且是回文数
 * 3 - 如果前一段不等于后一段，首先确定位数。如果位数相同，则不是回文数
 * 4 - 如果前一段不等于后一段，确定位数后前一段较小，则后一段除10并去掉小数
 * 5 - 如果前一段和除10后的后一段相等，则是奇数位的回文数，否则不是回文数
 */
public class PalindromeNumber {
    @Test
    public void test() {
        System.out.println(this.isPalindrome(10));
    }

    private boolean isPalindrome(int x) {
        // 0 - 负数和末尾为0的数绝对不是回文数
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        // 1 - 将数字分为两段，一段从后往前退，一段从前往后进，直到前一段小于等于后一段为止
        int front = x, end = 0, times = 0;
        while (front > end) {
            end = end * 10 + front % 10;
            front /= 10;
            times++;
        }
        if (front == end || times == 1 // 2 - 如果前一段等于后一段，说明这个数字一共偶数个，并且是回文数
                || (front / (int) Math.pow(10, times) == 0 // 3 - 如果前一段不等于后一段，首先确定位数。如果位数相同，则不是回文数
                && end / 10 > 0 && end / 10 == front)) // 4 - 如果前一段不等于后一段，确定位数后前一段较小，则后一段除10并去掉小数
        // 5 - 如果前一段和除10后的后一段相等，则是奇数位的回文数，否则不是回文数
        {
            return true;
        }
        return false;
    }
}