package com.ant.question01;


import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * </P>
 *
 * @author Ant
 * @since 2022/11/18 9:26 下午
 **/
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    rst[0] = i;
                    rst[1] = j;
                    return new int[]{i,j};
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ints = twoSum(nums, target);
        Arrays.stream(ints).forEach(System.out::print);
    }
}
