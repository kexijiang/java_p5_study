package com.kxjiang.java_p5_study.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lyh
 * @date 2022-04-09 23:01
 */
@SuppressWarnings("all")
public class 只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{30000,500,100,30000,100,30000,100}));;
    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, ((map.get(num)) + 1));
            }else{
                map.put(num, 1);
            }
        }
        AtomicInteger res = new AtomicInteger();
        map.forEach((key, value) -> {
            if (value == 1) {
                res.set(key);
            }
        });
        return res.get();
    }
}
