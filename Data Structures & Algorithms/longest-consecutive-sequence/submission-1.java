class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int answer = 1;
        HashSet<Integer> arrayContain = new HashSet<>();
        PriorityQueue<Integer> arraySeq = new PriorityQueue<>((a,b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!arrayContain.contains(temp)) {
                arrayContain.add(temp);
                arraySeq.add(temp);
            }
        }
        int prev = arraySeq.poll();
        int nowSeqNum = 1;
        int temp;
        while(!arraySeq.isEmpty()){
            temp = arraySeq.poll();
            if (temp - prev == 1) {
                nowSeqNum++;
                if(nowSeqNum > answer) answer = nowSeqNum;
            } else {
                nowSeqNum = 1;    
            }
            prev = temp;
        }
        return answer;
    }
}
