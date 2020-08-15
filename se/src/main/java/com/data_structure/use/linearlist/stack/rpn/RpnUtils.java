package com.data_structure.use.linearlist.stack.rpn;

import com.data_structure.impl.linearlist.stack.GeneralArrayStack;
import org.junit.Test;

import java.util.HashMap;

/**
 * <p>
 * 逆波兰表达式
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/9 16:27
 */
public class RpnUtils {

    private final HashMap<String,Integer> map = new HashMap<String, Integer>(){{
        put("+",1);
        put("-",1);
        put("*",2);
        put("/",2);
        put("(",3);
        put(")",3);
    }};

    private GeneralArrayStack<Integer> stack = new GeneralArrayStack<>();

    // 使用中缀表达式计算
    public int resultInfix(String expression){
        return result(transInfixToSuffix(expression));
    }

    // 使用后缀表达式计算
    public int resultSuffix(String expression){
        return result(expression);
    }

    public String transInfixToSuffix(String expression){
        // 9 + ( 3 - 1 ) * 3 + 10 / 2
        // 9 3 1 - 3 * + 10 2 / +
        final StringBuilder sb = new StringBuilder();

        return "";
    }

    private int result(String expression){
        int result = 0;
        final String[] split = expression.split(" ");
        for (String s : split) {
            if(map.containsKey(s)){
                int right = stack.peek();
                stack.pop();
                int left = stack.peek();
                stack.pop();
                switch (s){
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    @Test
    public void demo(){
        System.out.println(result("9 3 1 - 3 * + 10 2 / +"));
    }
}
