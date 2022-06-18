//start : 4 : 20
//end : 4 : 30

class RandomizedCollection {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Set<Integer>> f = new HashMap<>();
    public RandomizedCollection() {
        
    }
    
    public boolean insert(int val) {
        if(f.containsKey(val)) {
            f.get(val).add(list.size());
            list.add(val);
            return false;
        } else {
            f.put(val, new HashSet<>());
            f.get(val).add(list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!f.containsKey(val)) {
            return false;
        }
        
        Set<Integer> set = f.get(val);
        int idx = -1;
        for(Integer k : set) {
            idx = k;
            break;
        }
        
        set.remove(idx);
        if(set.size() == 0) f.remove(val);
        
        if(idx == list.size() - 1) {
            list.remove(list.size() - 1);
            return true;
        }
        
        
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        Set<Integer> lastSet = f.get(last);
        lastSet.remove(list.size() - 1);
        lastSet.add(idx);
        list.remove(list.size() - 1);
        return true;
    
    }
    
    public int getRandom() {
        Random rand = new Random();
        int rIndex = rand.nextInt(list.size());
        return list.get(rIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */