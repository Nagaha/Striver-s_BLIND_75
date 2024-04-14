/*15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//We sort it first
        List<List<Integer>> list=new ArrayList<>();
        //We go for a two pointer approach
        for(int i=0;i<nums.length-2;i++){//left end
          if(i>0 && nums[i]==nums[i-1]) continue;//incase we undergo repeated elements
            int j=i+1;//1st right 
            int k=nums.length-1;//2nd right end

            while(j<k){//if they don't cross each other
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){//When they a add upto zero we add them to list
                   list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;//we move the right one ahead
                    k--;//we move the right end one step before
                    while(j<k && nums[j]==nums[j-1]) j++;
                    //we move untill we encounter a non repeated element as well as we don't 
                    //cross j and k beacuse they are the ends
                    while(j<k && nums[k]==nums[k-1]) k--;
                }
                else if(sum<0){//we move the right pointer
                    j++;
                }
                else if(sum>0){//we move the right end pointer
                    k--;
                }
            }
//This is lyk 3 pointers but we have the first pointer as static and internally moves the two main pointers

        }
        return list;
    }
}
