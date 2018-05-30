package easy;

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * 主要思路是迭代nums数组中每一个数字. 对当前数字, 先查HashMap中是否存在已其作为key的项.
 * 如果没有, 则把target与当前数字的差值diff作为key, 当前数字在nums中的索引作为value存入HashMap中.
 * 如果有, 则表示成功匹配, 则把`key对应的value`和`当前数字在nums中的索引`返回即可.
 *
 * 简单来说就是用前面数字与target的差值diff作为HashMap的keys, 来避免双重循环.
 */

import java.util.*;

public class No_0001_TowSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            int el = nums[i];
            int diff = target - el;
            if(map.containsKey(el)) {
                ret[0] = map.get(el);
                ret[1] = i;
                return ret;
            }
            map.put(diff, i);
        }

        return ret;
    }

    // Test
    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 11, 15};
        int target = 22;
        int[] ret = new No_0001_TowSum().twoSum(nums, target);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
