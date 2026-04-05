class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numsContained = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (numsContained.contains(nums[i])){
                return true;
            } else {
                numsContained.add(nums[i]);
            }
        }
        return false;
    }
}