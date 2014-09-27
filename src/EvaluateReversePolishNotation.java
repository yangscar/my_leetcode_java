public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String token: tokens){
            if (token.equals("+")){
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.offerLast(a+b);
            }else if (token.equals("-")){
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.offerLast(b-a);
            }else if (token.equals("*")){
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.offerLast(a*b);
            }else if (token.equals("/")){
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.offerLast(b/a);
            }else {
                stack.offerLast(Integer.parseInt(token));
            }
        }
        return stack.removeLast();
    }
}
