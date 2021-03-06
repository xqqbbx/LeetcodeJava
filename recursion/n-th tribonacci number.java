//https://leetcode.com/problems/n-th-tribonacci-number/
class Solution {
    private static final int MAX_N = 38;
    int[] result = new int[MAX_N];
    
    public int tribonacci(int n) {
        Arrays.fill(result, -1);
        int num = store(n);
        return num;
    }
    
    private int store(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            result[n] = 0;
        } else if(n == 1 || n == 2) {
            result[n] = 1;
        } else if(result[n] < 0) {
            result[n] = store(n-3) + store(n-2) + store(n-1);
        }
        return result[n];
    }
}