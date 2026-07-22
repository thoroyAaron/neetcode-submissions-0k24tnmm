class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        int mid = 0;
        while(lo < hi){
            mid = (lo + hi) / 2;
            int sum = 0;
            for(int i : nums){
                if(i <= mid){
                    sum = sum + 1;
                }
            }
            if(sum > mid){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
