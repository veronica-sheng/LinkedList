/*
2
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
12/06/2018 10:26 - 11:26
*/
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
/*
Complexity Analysis
O(2n) = O(n)
In the worst case, each char will be visited twice by i and j.
Space complexity: O(min(m, n)).
The size of the Set is upper bounder by the size of the string n and 
the size of the charset/alphabet m.
*/



/*
The abnove solution requires at most 2n steps. In fact, it could be optimized to 
require only n steps. Instead of using a ste to tell if a char exists or not,
we could define a mapping of the char to its index. Then we can skip the chars
immediately when we found a repeated char.

The reason is that if s[j] have a duplicate in the range[i,j) with index j'. we
don't need to increase i little by little. We skip all the elements in the range
[i, j'), and let i to be j' + 1 directly.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }




