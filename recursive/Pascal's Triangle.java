/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

*/

//recursive solution
//functional but will cause time limit exceeded when hit rowIndex hit 28

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            res.add(helper(rowIndex, i));
        }
        return res;
    }
    private int helper(int rowIndex, int position){
        if(rowIndex == 1 || position == 0 || position == rowIndex)
            return 1;
        else 
            return helper(rowIndex - 1, position) + helper(rowIndex - 1, position - 1);
    }
}

// iterative solution
public class Solution {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        return Arrays.asList(arr);
    }
}