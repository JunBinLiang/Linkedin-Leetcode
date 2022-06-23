/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxD = -1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxD = dfs(nestedList, 1);
        return dfs1(nestedList, 1);
    }
    
    public int dfs(List<NestedInteger> list, int depth) {
        int dep = 0;
        for(int i = 0; i < list.size(); i++) {
            NestedInteger nest = list.get(i);
            if(nest.isInteger()) {
                
            } else {
                dep = Math.max(dep, dfs(nest.getList(), depth + 1));
            }
        }
        return dep + 1;
    }
    
    public int dfs1(List<NestedInteger> list, int depth) {
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            NestedInteger nest = list.get(i);
            if(nest.isInteger()) {
                sum += ((maxD - depth + 1) * nest.getInteger());
            } else {
                sum += dfs1(nest.getList(), depth + 1);
            }
        }
        return sum;
    }
}