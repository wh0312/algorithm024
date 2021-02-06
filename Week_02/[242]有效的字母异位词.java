//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 336 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++)
        {
            Character c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++)
        {
            Character c = t.charAt(i);
            if(countMap.containsKey(c))
            {
                countMap.put(c, countMap.get(c) - 1);
            } else
            {
                return false;
            }
        }
        for(Map.Entry<Character, Integer> entry : countMap.entrySet())
        {
            if(entry.getValue() != 0)return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
