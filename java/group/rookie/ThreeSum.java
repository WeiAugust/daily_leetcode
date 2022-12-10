package group.rookie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * 15.三数之和
 * 3 <= nums.length <= 3000
 * 10^5 <= nums[i] <= 10^5
 * 思路：先排序，O(nlogn);
 */
public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int numA = nums[i];
            int k = n - 1;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] + nums[i] > 0) {
                    --k;
                }

                if (j == k) {
                    break;
                }

                if (nums[j] + nums[k] + nums[i] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }

            }
        }
        return ans;
    }
}
