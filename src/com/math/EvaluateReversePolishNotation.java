package com.math;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens={"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation(逆波兰表达式).
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * Some examples:
     *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     * 遇到数字就入栈，遇到运算符号就出栈两个数运算  
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        for(String ele:tokens){
            if(ele.equals("+") || ele.equals("*") || ele.equals("-") || ele.equals("/")){
                int two=stack.pop();
                int one=stack.pop();
                int res=jisuan(one,two,ele);
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(ele));
            }
        }
        return stack.pop();
    }
    private static int jisuan(int one,int two,String operator){
        if(operator.equals("+")){
            return one+two;
        }else if(operator.equals("*")){
            return one*two;
        }else if(operator.equals("-")){
            return one-two;
        }else{
            return one/two;
        }
    }
}
