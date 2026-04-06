class Solution {

    public String encode(List<String> strs) {
        String s = new String();
        for(int i = 0; i < strs.size(); i++) {
            String temp = strs.get(i);
            int strLength = temp.length();
            s = s + Integer.toString(strLength) + "#" + temp;
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> decodeString = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int j = str.indexOf('#', i);         
            int len = Integer.parseInt(str.substring(i, j));
            decodeString.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;                      
        }

        return decodeString;
    }
}
