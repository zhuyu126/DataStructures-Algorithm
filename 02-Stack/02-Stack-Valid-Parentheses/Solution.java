import java.util.Stack;

/**
 * LeetCode 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char topChar=stack.pop();
                if (c==')'&& topChar!='('){
                    return false;
                }else if(c==']' && topChar!='['){
                    return false;
                }else if(c=='}' && topChar!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}([)]{"));
        System.out.println(new Solution().isValid("([{}])"));
    }
}
