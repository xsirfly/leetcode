package xsir;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer>  s = new Stack<>();
        int op1, op2;
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                op1 = s.pop();
                op2 = s.pop();
                s.push(op2 + op1);
            } else if ("-".equals(tokens[i])) {
                op1 = s.pop();
                op2 = s.pop();
                s.push(op2 - op1);
            } else if ("*".equals(tokens[i])) {
                op1 = s.pop();
                op2 = s.pop();
                s.push(op2 * op1);
            } else if ("/".equals(tokens[i])) {
                op1 = s.pop();
                op2 = s.pop();
                s.push(op2 / op1);
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();

    }
}
