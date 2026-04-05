class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexTarget = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(indexTarget.containsKey(nums[i])) return new int[]{indexTarget.get(nums[i]), i};

            indexTarget.put(target - nums[i], i);
        }

        return new int[]{};
    }
}
