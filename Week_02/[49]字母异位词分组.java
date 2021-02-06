//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 650 👎 0

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> countMap = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++)
        {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> strList = countMap.getOrDefault(key, new ArrayList<String>());
            strList.add(str);
            countMap.put(key, strList);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : countMap.entrySet())
        {
            List<String> value = entry.getValue();
            result.add(value);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
