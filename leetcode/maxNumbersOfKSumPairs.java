// https://leetcode.com/problems/max-number-of-k-sum-pairs/

class Solution {
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int p = 0;
        int i = 0;
        int j = nums.length-1;

        while(i<j){
            if(nums[i] + nums[j] > k){
                j--;
            } else if(nums[i] + nums[j] < k ){
                i++;
            } else if( nums[i] + nums[j] == k){
                p++;
                i++;
                j--;
            }

        }

        return p;
        
    }
}
