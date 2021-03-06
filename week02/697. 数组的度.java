/*697. 数组的度
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 

示例 1：

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2：

输入：[1,2,2,3,1,4,2]
输出：6
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
      HashMap<Integer,Integer> num_counts = new HashMap();
      int degree = 0;
      HashMap<Integer,Integer> first_seen = new HashMap();
      int min_length = 0;

      for(int i=0;i<nums.length;i++){
          first_seen.putIfAbsent(nums[i],i);
          num_counts.put(nums[i],num_counts.getOrDefault(nums[i],0) + 1);
       if(num_counts.get(nums[i])> degree){
            degree = num_counts.get(nums[i]);
            min_length = i - first_seen.get(nums[i]) + 1;
       }else if(num_counts.get(nums[i]) == degree){
            min_length = Math.min(min_length, i - first_seen.get(nums[i]) + 1);
       }
      }
      return min_length;
    }
 }
