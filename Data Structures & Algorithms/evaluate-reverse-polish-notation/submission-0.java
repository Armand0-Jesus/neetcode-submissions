// Evaluate Reverse Polish Notation
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack <>();

        for (String expression : tokens) {
            switch (expression) {
                case "+" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                } 
                case "*" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                }
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                }
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }

                default -> stack.push(Integer.parseInt(expression));
            }
        }

        return stack.pop();
    }
}
