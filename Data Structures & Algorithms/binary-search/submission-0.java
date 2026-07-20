class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while(left <= right){
            middle = (left + right) / 2;
            int get_num = nums[middle];
            if (get_num == target) return middle;
            if (get_num > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
