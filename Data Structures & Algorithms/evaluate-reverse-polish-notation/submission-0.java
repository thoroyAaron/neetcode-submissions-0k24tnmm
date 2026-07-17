class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");
        
        for (String token : tokens) {
            if (operators.contains(token)) {
                // 注意：先 pop 出来的是右操作数！
                int right = stack.pop();
                int left = stack.pop();
                int result = calculate(left, right, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private int calculate(int left, int right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;  // Java 整数除法向零截断，符合逆波兰要求
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}