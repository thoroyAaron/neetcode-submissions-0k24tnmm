class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('[', ']');
        m.put('{', '}');
        Stack<Character> stack4c = new Stack<>();
        Set<Character> keyset = m.keySet();

        for(char s1 : s.toCharArray()){
            if (keyset.contains(s1)){
                stack4c.push(s1);
            }else{
                if(stack4c.isEmpty()) return false;
                if(s1 != (m.get(stack4c.pop()))) return false;
            }
        }
        return stack4c.isEmpty();
    }
}