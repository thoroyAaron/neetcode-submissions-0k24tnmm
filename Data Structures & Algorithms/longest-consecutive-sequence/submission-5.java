class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> containSeq = new HashSet<>();
        int answerNum = 0;
        for (int i = 0; i < nums.length; i++) {
            containSeq.add(nums[i]);
        }
        for (int num : containSeq) {
            if (!containSeq.contains(num - 1)){
                int length = 1;
                while(containSeq.contains(num + length)){
                    length++;
                }
                answerNum = Math.max(answerNum, length);
            }
        }
        return answerNum;
    }
}
