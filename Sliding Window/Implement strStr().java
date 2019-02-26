/*
28
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/
class Solution1{
    public int strStr(String haystack, String needle) {
        //if(haystack == null || needle == null) return -1;
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2) return -1;
        for(int i = 0; i < len1 - len2 + 1; i++){
            int count = 0;
            while(count  < len2 && haystack.charAt(i + count) == needle.charAt(count))
                count++;
            if(count == len2) return i;
        }
        return -1;
    }
}

class Solution2 {//sliding window
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        int len1 = haystack.length();
        int len2 = needle.length();
        int i = 0;
        int j = len2;
       
        while(i <=len1 - len2 && len2 < len1){
            if(haystack.substring(i,j).equals(needle))
                return i;
            i++;
            j++;
        }
        return -1 ;
    }
}