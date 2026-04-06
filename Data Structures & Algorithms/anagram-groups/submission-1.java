class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> classifyGroup = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            String temp = strs[i];
            for(int j = 0; j < temp.length(); j++){
                count[temp.charAt(j) - 'a']++;
            }
            String s = Arrays.toString(count);
            classifyGroup.computeIfAbsent(s, k -> new ArrayList<>()).add(temp);
        }

        return new ArrayList<>(classifyGroup.values());
    }
}
