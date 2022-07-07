class Solution {
    
    public boolean canFinish(int n, int[][] edges) {
        List<Integer> graph[] = new ArrayList[n];
        Set<Integer> set = new HashSet<>(); //finished course
        int in[] = new int[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int edge[] : edges) {
            //edge[1] -> edge[0]  u -> v
            int u = edge[1], v = edge[0];
            graph[u].add(v);
            in[v] += 1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) {
                //no pre, can take
                q.add(i);
                set.add(i);
            }
        } 
        
        while(q.size() > 0) {
            int root = q.poll();
            for(int next : graph[root]) {
                if(set.contains(next)) {
                    //cycle 
                    return false;
                }
                in[next]--;
                if(in[next] == 0) {
                    set.add(next);
                    q.add(next);
                }
            }
        }
        return set.size() == n;
    }
}