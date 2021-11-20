package com.goinhn.algorithm.datastructure.linertable.queue;

import java.util.*;

/**
 * <p>
 * leetcode 692
 * <p>
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * 时间复杂度:O(nlogn)
 * 空间复杂度:O(n)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-15T09:52:25
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsCount = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsCount.put(words[i], wordsCount.getOrDefault(words[i], 0) + 1);
        }

        List<String> candidates = new ArrayList(wordsCount.keySet());

        Collections.sort(candidates, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordsCount.get(o1).equals(wordsCount.get(o2)) ? o1.compareTo(o2) :
                        wordsCount.get(o2) - wordsCount.get(o1);
            }
        });

        return candidates.subList(0, k);

    }

}
