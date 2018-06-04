package hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 *
 */
public class No_0004_Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums_a, int[] nums_b) {
        double ret = 0.0;

        int length_a = nums_a.length;
        int length_b = nums_b.length;

        if (length_a == 0 && length_b == 0) {
            return 0.0;
        }
        if (length_a == 0) {
            return this.medianFromSingleArray(nums_b);
        }
        if (length_b == 0) {
            return this.medianFromSingleArray(nums_a);
        }

        // Real logic
        int length_total = length_a + length_b;
        int left_bound = 0;
        int left_idx_a = 0;
        int left_idx_b = 0;
        int accept_counter = 0;

        // 如果总共有奇数个元素
        if (length_total % 2 == 1) {
            int should_accept = length_total / 2 + 1;
            while (accept_counter < should_accept) {
                // 如果数组a和数组b都没迭代到尾
                if (left_idx_a < length_a && left_idx_b < length_b) {
                    // compare
                    if(nums_a[left_idx_a] < nums_b[left_idx_b]) {
                        left_bound = nums_a[left_idx_a];
                        accept_counter++;
                        left_idx_a++;
                    }
                    else {
                        left_bound = nums_b[left_idx_b];
                        accept_counter++;
                        left_idx_b++;
                    }
                }
                else {
                    // 如果数组a还没迭代到尾, 但数组b已经迭代完了
                    if (left_idx_a < length_a) {
                        left_bound = nums_a[left_idx_a];
                        accept_counter++;
                        left_idx_a++;
                    }
                    // 如果数组b还没迭代到尾, 但数组a已经迭代完了
                    else {
                        left_bound = nums_b[left_idx_b];
                        accept_counter++;
                        left_idx_b++;
                    }
                }
            }
            ret = left_bound;
        }
        // 如果有偶数个元素
        else {
            int should_accept = length_total / 2 + 1;
            int prev_left_bound = 0;

            while (accept_counter < should_accept) {
                // 如果数组a和数组b都没迭代到尾
                if (left_idx_a < length_a && left_idx_b < length_b) {
                    // compare
                    if(nums_a[left_idx_a] < nums_b[left_idx_b]) {
                        prev_left_bound = left_bound;
                        left_bound = nums_a[left_idx_a];
                        accept_counter++;
                        left_idx_a++;
                    }
                    else {
                        prev_left_bound = left_bound;
                        left_bound = nums_b[left_idx_b];
                        accept_counter++;
                        left_idx_b++;
                    }
                }
                else {
                    // 如果数组a还没迭代到尾, 但数组b已经迭代完了
                    if (left_idx_a < length_a) {
                        prev_left_bound = left_bound;
                        left_bound = nums_a[left_idx_a];
                        accept_counter++;
                        left_idx_a++;
                    }
                    // 如果数组b还没迭代到尾, 但数组a已经迭代完了
                    else {
                        prev_left_bound = left_bound;
                        left_bound = nums_b[left_idx_b];
                        accept_counter++;
                        left_idx_b++;
                    }
                }
            }
            ret = (left_bound + prev_left_bound) / 2.0;
        }


        return ret;
    }

    public double medianFromSingleArray(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length / 2 - 1] + nums[length / 2]) / 2;
        } else {
            return nums[length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {10, 50, 60};
        int[] nums2 = new int[] {2, 3, 6};

        No_0004_Median_of_Two_Sorted_Arrays obj = new No_0004_Median_of_Two_Sorted_Arrays();

        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
        System.out.println(obj.findMedianSortedArrays(nums2, nums1));
    }

}
