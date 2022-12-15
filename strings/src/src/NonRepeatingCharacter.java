import java.util.Arrays;
import java.util.Scanner;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String str = new String ("hello");
        String newStr = new String ("zxvczbtxyzvy");

        System.out.println(nonrepeatingCharacter(str));
        System.out.println(nonrepeatingCharacter(newStr));
    }

    static char nonrepeatingCharacter(String s) {
        int[] fI = new int[26];
        char res = '$';
        Arrays.fill(fI, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            //denotes the element is not present
            if (fI[index] == -1)
                fI[index] = i;
                //element has appeared at least once
            else
                fI[index] = -2;
        }
        int resIndex = Integer.MAX_VALUE;
        for (int i = 0; i < fI.length; i++) {
            if (fI[i] >= 0)
                resIndex = Math.min(resIndex, fI[i]);
        }
        System.out.println(resIndex);
        res = resIndex == Integer.MAX_VALUE ? res : s.charAt(resIndex);
        return res;
    }
}
