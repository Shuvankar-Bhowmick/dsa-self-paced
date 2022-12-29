import java.util.HashMap;

public class LongestSubstringOfDistinctCharacters {
    static int longestSubstrDistinctChars(String S){
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int len = S.length(), res = 0, maxResult = Integer.MIN_VALUE;
        int left, right;
        left = right = 0;
        while (right < len) {

            if (map.containsKey(S.charAt(right))) {
                left = Math.max(map.get(S.charAt(right)) + 1, left);
            }

            map.put(S.charAt(right), right);
            res = right - left + 1;
            maxResult = Math.max(res, maxResult);
            right++;
        }

        return maxResult;
    }
}
