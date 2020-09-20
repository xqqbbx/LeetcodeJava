//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
class Solution {
    Set<String> result = new HashSet<>();
    int max = 0;
    public int maxUniqueSplit(String s) {
        int curr = 0;
        maxUniqueSplit(s, curr);
        return max; 
    }
    
    public void maxUniqueSplit(String s, int curr) {
        for(int i = curr+1; i <= s.length(); i++) {
            String todo = s.substring(curr, i);
            if(!result.contains(todo)) {
                result.add(todo);
                maxUniqueSplit(s, i);
                
                if(result.size() > max) {
                    max = result.size();
                }
                result.remove(todo);
            }
        } 
    } 
}