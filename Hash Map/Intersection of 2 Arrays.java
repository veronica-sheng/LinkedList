/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/

//brute and force
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    res.add(nums1[i]);
                    // every time the item in nums2 is compared and is the same with nums1,
                    // we set it as max, which means we will not compare it again(if nums2
                    // is represented by LinkedList, we need to remove this item)
                    nums2[j] = Integer.MAX_VALUE; 
                    // every time we find the same item in nums2, we need to break this for 
                    // loop, which means we should compare the next item in nums1 with nums2
                    break;
                }
            }
        return toIntArray(res);
        
    }
    private int[] toIntArray(ArrayList<Integer> res){
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            resArray[i] = res.get(i);
        return resArray;
    }
}

// Hash Map
// evertime we see "array unsortem", " elements can appear many times" we should 
// take hash map into consideration.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++){
            // eg: nums1{1,1}, nums2{1,1,1}, every time we find the same key in nums2,
            // we should decrease the corresponding value, when the value becomes 0, 
            // means we do not hold this key any longer.
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                res.add(nums2[i]);
                map.put((nums2[i]), map.get(nums2[i])- 1);
            }
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            r[i] = res.get(i);
        return r;
    }
}







