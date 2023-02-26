package com.kxjiang.java_p5_study.algorithm;

import java.util.Stack;

/**
 * 作者: Jiang
 * 创建时间: 2023/2/12 14:11
 * 描述:
 */
public class 基本计算器二 {
  public static void main(String[] args) {
    System.out.println(calculate(" 3/2 "));
  }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        for(int i = 0;i < s.length(); i++){
            char c = s.toCharArray()[i];
            // 如果是数字,连续读取到数字结尾
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            // 遇到不是数字 或到字符串结尾 将前面存的数字存入栈
            if((!Character.isDigit(c) && c!=' ') || i == s.length() - 1){
                switch(sign){
                    case '+':{
                        stack.push(num);
                        break;
                    }
                    case '-':{
                        stack.push(-num);break;
                    }
                    case '*':{
                        int temp = stack.pop() * num;
                        stack.push(temp);break;
                    }
                    case '/':{
                        int temp = stack.pop() / num;
                        stack.push(temp);break;
                    }
                }
                num = 0;
                sign = c;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }
}
