public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> list) {
        StringBuilder str = new StringBuilder();
        for(String s : list) {
            str.append(s.length()).append(".").append(s);
        }
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            int j = i;
            int cnt = 0;
            while(j < s.length() && isd(s.charAt(j))) {
                cnt = cnt * 10 + (s.charAt(j) - '0');
                j++;
            }
            
            StringBuilder str = new StringBuilder();
            j++;
            for(int x = 0; x < cnt; x++) {
                str.append(s.charAt(j));
                j++;
            }
            i = j - 1;
            res.add(str.toString());
        }
        return res;
    }
    
    public boolean isd(char c) {
        return c - '0' >= 0 && c - '0' < 10;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));