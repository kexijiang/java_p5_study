package com.kxjiang.java_p5_study.algorithm;

/**
 * 作者: Jiang
 * 创建时间: 2023/2/5 20:04
 * 描述:
 */
public class 正则表达式匹配 {
  public static void main(String[] args) {
    //
    System.out.println(isMatch("aa","a"));
  }
    public static boolean isMatch(String s, String p) {
        boolean res = false;

        int index = 0;

        while(index < p.length()){
            if(p.indexOf(index) == '.'){
                index++;
            }else if(p.charAt(index) == '*'){
                if(p.charAt(index-1) == '.'){
                    return true;
                }else if(s.indexOf(p.charAt(index-1))==-1){
                    return false;
                }else{
                    return true;
                }
            }else{
                index++;
            }
        }
        return res;
    }
}
