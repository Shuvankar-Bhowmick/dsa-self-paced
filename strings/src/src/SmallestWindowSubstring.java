import java.util.HashMap;
import java.util.Scanner;

public class SmallestWindowSubstring {

    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        String p = new Scanner(System.in).next();
        String ans = smallestWindow(s, p);
        System.out.println(ans);
    }
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        int haveCount = 0, needCount;
        int minLength = Integer.MAX_VALUE, startIndex = 0;
        int i = 0, j = 0;
        int n = s.length();

        if(s.length() < p.length()) return "-1";

        while (i < p.length()) {
            int val = need.getOrDefault(p.charAt(i), 0) + 1;
            need.put(p.charAt(i), val);
            i++;
        }
        needCount = need.size();
        i = 0;
        while (j < n) {
            //if haveCount is less than needCount then we expand the window and keep adding characters to have map
            if (haveCount < needCount) {
                char ch = s.charAt(j);
                if (need.containsKey(ch)) {
                    int val = have.getOrDefault(ch, 0) + 1;
                    have.put(ch, val);

                    if (val == need.get(ch)) haveCount++;
                }
                j++;
            }
            //if haveCount is equal to needCount then it means we have got the required window
            //now we try to further minimize the size of the window if possible
            else {
                if (j - i < minLength) {
                    startIndex = i;
                    minLength = j - i;
                }
                //popping the characters from the front(start)
                char ch = s.charAt(i);
                if (have.containsKey(ch)) {
                    int val = have.get(ch) - 1;
                    have.put(ch, val);

                    if (val < need.get(ch)) haveCount--;
                }
                i++;
            }
        }
        //while we have an answer and can also reduce the window
        while ((haveCount == needCount)) {
            if (j - i < minLength) {
                startIndex = i;
                minLength = j - i;
            }

            char ch = s.charAt(i);
            if (have.containsKey(ch)) {
                int val = have.get(ch) - 1;
                have.put(ch, val);

                if (val < need.get(ch)) haveCount--;
            }
            i++;
        }
        if (minLength == Integer.MAX_VALUE) return "-1";

        return s.substring(startIndex, startIndex + minLength);
    }

}
