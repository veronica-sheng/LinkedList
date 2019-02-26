/*
159
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
12/05/2018 19:50 - 20:55
12/06/2018 09:10 - 09:28
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        int counter = 0;
        while(end < s.length()){
            char right = s.charAt(end);
            //map.getOrDefault:if the map contains the key, return its value
            //otherwise return the default value, which is 0 here.
            map.put(right, map.getOrDefault(right,0) + 1);
            if(map.get(right) == 1)
                counter++; // when encounter a new char
            end++;
            //System.out.println("counter:" + counter);
            //System.out.println("end:" + end);
            while(counter > 2){// when there are chars more that 2, we need to shift the window
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                // when  map.get(left) == 0, which means that left is consumed out, and the window 
                // now contains only two distinctive chars.
                if(map.get(left) == 0)
                    counter--;
                start++; 
                System.out.println("start:" + start);
            }
            res = Math.max(res, end - start); 
            //System.out.println(res);
        }
        return res;
    }                
}