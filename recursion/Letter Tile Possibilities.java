class Solution {
    Set<String> set = new HashSet<>();
    String tiles;
    public int numTilePossibilities(String tiles) {
        this.tiles = tiles;
        getTile(tiles, 0);
        return set.size();
    }
    
    private void getTile(String tiles, int curr) {
        if(curr >= tiles.length()) {
            return;
        }
        char todo = tiles.charAt(curr);
        Set<String> toAdd = new HashSet<>();
        for(String added : set) {
            toAdd.addAll(append(added, todo));
            String reverse = new StringBuilder(added).reverse().toString();
            toAdd.addAll(append(reverse, todo));
        }
        set.addAll(toAdd);
        set.add(String.valueOf(todo));
        getTile(tiles, curr+1);
    }
    
    private Set<String> append(String source, char c) {
        Set<String> result = new HashSet<>();
        for(int i = 0; i <= source.length(); i++) {
            String add = source.substring(0,i) + String.valueOf(c) + source.substring(i, source.length());
            if(add.length() <= tiles.length()) {
                result.add(add);
            }
        }
        return result;
    }
}