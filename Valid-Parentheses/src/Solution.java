import java.util.Stack;

/**
 * @Author: cc
 * @Date: 2019/12/10 17:34
 */
public class Solution {

    /**
     * 有效的括号
     * https://leetcode-cn.com/problems/valid-parentheses/
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c =='[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c =='}' && topChar !='{')
                    return false;
                if (c==']' && topChar != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
