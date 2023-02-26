package com.kxjiang.java_p5_study.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** 作者: Jiang 创建时间: 2023/2/15 21:15 描述: */
public class 根据字符出现频率排序 {
  public static void main(String[] args) {
    //
    System.out.println(frequencySort("tree"));
  }

  public static String frequencySort(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>(
            (entry1, entry2) -> {
              // 按照键值对中的值 从大到小排序
              return entry2.getValue().compareTo(entry1.getValue());
            });

    // 放入优先级队列
    map.entrySet().forEach(pq::offer);

    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> entry = pq.poll();

      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey());
      }
    }

    return sb.toString();
  }
}
