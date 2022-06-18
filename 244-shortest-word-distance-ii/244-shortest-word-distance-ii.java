//start : 11 : 47

class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] a) {
        for(int i = 0; i < a.length; i++) {
            if(!map.containsKey(a[i])) {
                map.put(a[i], new ArrayList<>());
            }
            map.get(a[i]).add(i);
        }
    }
    
    public int shortest(String s, String t) {
        List<Integer> l1 = map.get(s);
        List<Integer> l2 = map.get(t);
        int res = Integer.MAX_VALUE;
        
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if(l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */