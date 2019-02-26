class Solution {
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