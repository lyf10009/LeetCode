package com;

import java.util.Stack;

import com.sun.corba.se.spi.orbutil.fsm.State;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens={"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation(Äæ²¨À¼±í´ïÊ½).
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * Some examples:
     *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
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
