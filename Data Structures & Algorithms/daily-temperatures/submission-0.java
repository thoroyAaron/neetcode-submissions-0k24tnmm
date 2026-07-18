class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < result.length; i++){
            int t = temperatures[i];
            while(!stack.empty() && t > temperatures[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            };
            stack.push(i);
        }

        return result;
    }
}
