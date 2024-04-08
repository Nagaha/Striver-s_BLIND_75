/*238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int R_product=1;
        ArrayList<Integer> zeroList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                R_product*=nums[i];
            }
            else{
                zeroList.add(i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(!zeroList.isEmpty()){
                if(!zeroList.contains(i) || zeroList.size()==nums.length || zeroList.size()>1){
                    nums[i]=0;
                }
                else{
                    nums[i]=R_product;
                }
            }
            else{
                 nums[i]=R_product/nums[i];
            }
        }
        return nums;
    }
}
