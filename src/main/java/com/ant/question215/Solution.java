package com.ant.question215;


import javax.swing.*;

/**
 * <p>
 * 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题
 *
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * </P>
 *
 * @author Ant
 * @since 2022/12/21 19:29
 **/
public class Solution {

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, nums.length, k - 1);
    }

    /**
     * <p>
     * 利用快排算法
     * </p>
     *
     * @param nums 待排序数组
     * @param n    数组长度
     * @return void
     */
    public static int quickSort(int[] nums, int n, int k) {
        return quickSortC(nums, 0, n - 1, k);
    }

    /**
     * <p>
     *
     * </p>
     *
     * @param nums 待排序数组
     * @param p    数组开始下标
     * @param r    数组结束下标
     * @return void
     */
    public static int quickSortC(int[] nums, int p, int r, int k) {
        if (p >= r) { return nums[k]; }

        // 获取分区点
        int q = partition(nums, p, r);
        if (k == q) {
            return nums[k];
        }

        if (k < q) {
            return quickSortC(nums, p, q - 1, k);
        }

        if (k > q) {
            return quickSortC(nums, q + 1, r, k);
        }



        return 0;
    }


    public static int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (nums[j] > pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                if (i != r) {
                    i = i + 1;
                }

            }
        }

        int temp2 = nums[r];
        nums[r] = nums[i];
        nums[i] = temp2;
        return i;
    }

    public static void main(String[] args) {
        // 示例1：[3,2,1,5,6,4], k = 2 输出：5
        // 示例2： [3,2,3,1,2,4,5,5,6], k = 4 输出：4
        int[] arr = new int[] {3,2,3,1,2,4,5,5,6};
        int kthLargest = findKthLargest(arr, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.printf("\n" + kthLargest);
    }

}