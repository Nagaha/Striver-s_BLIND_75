/*152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int temp=1;
            for(int j=i;j<nums.length;j++){
             temp*=nums[j];
             max=Math.max(max,temp);
            }
        }
        return max;
    }
}
