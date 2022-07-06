struct Tree {
    int Next[26];
    int cnt = 0;
    void init() {
        memset(Next, -1, sizeof(Next));
        cnt = 0;
    }  
} trees[1000000];
int id = 0;
map<string, int> f;

class Trie {
public:
    Trie() {
        id = 1;
        trees[0] = {};
        trees[0].init();
        f.clear();
    }
    
    void insert(string s) {
        int root = 0;
        f[s]++;
        for(int i = 0; i < s.size(); i++) {
            int idx = s[i] - 'a';
            if(trees[root].Next[idx] == -1) {
                trees[id] = {};
                trees[id].init();
                trees[id].cnt++;
                trees[root].Next[idx] = id;
                root = id;
                id++;
            } else {
                root = trees[root].Next[idx];
                trees[root].cnt++;
            }
        }
    }
    
    int countWordsEqualTo(string s) {
        return f[s];
    }
    
    int countWordsStartingWith(string s) {
        int root = 0;
        for(int i = 0; i < s.size(); i++) {
            int idx = s[i] - 'a';
            if(trees[root].Next[idx] == -1) {
                return 0;
            }
            root = trees[root].Next[idx];
        }
        if(root != -1) {
            return trees[root].cnt;
        }
        return 0;
    }
    
    void erase(string s) {
        int root = 0;
        for(int i = 0; i < s.size(); i++) {
            int idx = s[i] - 'a';
            root = trees[root].Next[idx];
            trees[root].cnt--; 
        }
        f[s]--;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * int param_2 = obj->countWordsEqualTo(word);
 * int param_3 = obj->countWordsStartingWith(prefix);
 * obj->erase(word);
 */
