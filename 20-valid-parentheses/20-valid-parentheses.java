//start : 7 : 00
//end : 7 : 03

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> f = new HashMap<>();
        f.put('{', '}');
        f.put('(', ')');
        f.put('[', ']');
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.size() == 0) {
                    return false;
                }
                if(f.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}