// https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=daily-question&envId=2024-03-02

class Solution {
    public int[] sortedSquares(int[] nums){}

        for(int i = 0; i< nums.length; i++){
            nums[i] *=nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}