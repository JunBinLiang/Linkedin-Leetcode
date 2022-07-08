class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer> graph[] = new ArrayList[n];
        int in[] = new int[n];
        Set<Integer> sets[] = new TreeSet[n];
        
        /*for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }*/
        Arrays.setAll(graph, e -> new ArrayList<>());
        Arrays.setAll(sets, x -> new TreeSet<>());
        
        for(int edge[] : edges) {
            //edge[0] -> edge[1]  u -> v
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            in[v] += 1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 0) {
                //no pre, can take
                q.add(i);
            }
        } 
        
        while(q.size() > 0) {
            int root = q.poll();
            for(int nxt : graph[root]) {
                sets[nxt].add(root);
                sets[nxt].addAll(sets[root]);
                in[nxt]--;
                if(in[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        
       
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) res.add(new ArrayList<>(sets[i]));
        return res;
        
    }
}

//sets[i] : all ancestor of i