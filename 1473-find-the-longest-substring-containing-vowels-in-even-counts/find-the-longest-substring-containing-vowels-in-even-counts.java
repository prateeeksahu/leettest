class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  
        int m = 0;
        int ml = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
           
            if (c == 'a') m ^= (1 << 0);
            else if (c == 'e') m ^= (1 << 1);
            else if (c == 'i') m ^= (1 << 2);
            else if (c == 'o') m ^= (1 << 3);
            else if (c == 'u') m ^= (1 << 4);
            
            if (map.containsKey(m)) ml = Math.max(ml, i - map.get(m));
            else map.put(m, i);
        }
        
        return ml;
    }
}
