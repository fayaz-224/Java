package Strings.Basics;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/description/
//group the anagrams together
//Input: ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class AnagramsGroup {  //TC: O(n · k log k)

    static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);  //if not sorting, use Character frequency array
            String key = new String(chars);

            //map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            //or
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);  //it should execute everytime not with else block
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }
}