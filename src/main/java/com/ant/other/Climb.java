package com.ant.other;


/**
 * <p>
 * 题目：
 * 假如有 n 个台阶，
 * 每次你可以最多走 m 个台阶，请问走这n个台阶有多少种走法。
 *
 * 思路：实际上，可以根据第一步的走法把所有走法分为 m 类，
 *      第一类，是第一步走1个台阶，第二类，是第一步走2个台阶，第三类，是第一步走3个台阶，
 *      （首先保证 m < n, 取 min（m,n）为终止条件)
 * </P>
 *
 * @author Ant
 * @since 2022/11/18 7:16 下午
 **/
public class Climb {

    public int climb(int n, int m) {
        int count = 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        for (int i = 1; i <= m && i < n; i++) {
            count += climb(n - i, m);
        }
        return count;
    }

    public static void main(String[] args) {
        Climb climb = new Climb();
        System.out.println(climb.climb(5, 3));
    }
}
