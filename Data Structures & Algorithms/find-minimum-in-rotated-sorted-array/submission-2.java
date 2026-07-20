class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        int min = 1001;

        while(left <= right){
            middle = (left + right) / 2;
            if(nums[left] <= nums[middle]){
                if(min > nums[left]) min = nums[left];
                left = middle + 1;
            } else {
                if(min > nums[middle]) min = nums[middle];
                right = middle - 1;
            }
        }
        return min;
    }
}
