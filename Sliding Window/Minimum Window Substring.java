/*
76
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
12/05/2108 21:55 - 22:55
12/06/2018 09:32 - 09:54
*/
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int counter = map.size();
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int head = 0;
        while(right < s.length()){
            char a = s.charAt(right);
            if(map.containsKey(a)){
                //if the map.get(a) < 0, means that # of a in s is more than t
                map.put(a, map.get(a) - 1);
                if(map.get(a) == 0)
                    counter--;
            }
            right++;
            //when the whole t accurs in s, we start to contract the left
            while(counter == 0){
                char b = s.charAt(left);
                if(map.containsKey(b)){
                    map.put(b, map.get(b) + 1);
                    //map.get(b) + 1 > 0 means s.charAt(left) touches the left boundary of valid window
                    if(map.get(b) > 0)
                        counter++;
                }
                if(right - left < res){
                    res = right - left;
                    head = left;
                }
                left++;
            }
        }
        if(res == Integer.MAX_VALUE) return "";
        return s.substring(head, head + res);
    }
}

