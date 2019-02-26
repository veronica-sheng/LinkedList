/*
438
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
12/06/2018 14:42 - 15:17
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int counter = map.size();
        int start = 0, end = 0;
        while(end < len1){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    counter--;
            }
            end++;
            while(counter == 0){
                char cTemp = s.charAt(start);
                if(map.containsKey(cTemp)){
                    map.put(cTemp, map.get(cTemp) + 1);
                    if(map.get(cTemp) > 0)
                        counter++;
                }
                if(end - start == len2)
                    res.add(start);
                start++;
            }
        }
       return res;
    }
}