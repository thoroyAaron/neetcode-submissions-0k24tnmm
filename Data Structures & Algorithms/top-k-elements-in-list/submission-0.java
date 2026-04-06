class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> countFreq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            if(countFreq.containsKey(temp)){
                int countNums = countFreq.get(temp);
                countFreq.replace(temp, ++countNums); 
            } else {
                countFreq.put(temp, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer,Integer> entry: countFreq.entrySet()){
            pq.offer(entry);
        }

        for (int i = 0; i < k; i++){
            answer[i] = pq.poll().getKey();
        }
        return answer;
    }
}
