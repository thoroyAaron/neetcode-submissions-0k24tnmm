class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> containSeq = new HashSet<>();
        int answerNum = 0;
        for (int i = 0; i < nums.length; i++) {
            containSeq.add(nums[i]);
        }

        for (int i : nums) {
            int tempLength  = 0;
            int tempInt = i;
            while(containSeq.contains(tempInt)){
                tempLength++;
                tempInt++;
            }
            answerNum = Math.max(answerNum, tempLength);
        }
        return answerNum;
    }
}
