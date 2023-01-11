import java.util.Arrays;
import java.util.Scanner;

public class CaseSort {
    public static void main(String[] args) {
        String str = new String();
        String newStr = new String();
        System.out.println("Enter string: ");
        str = new Scanner(System.in).nextLine();
        newStr = caseSort(str);
        System.out.println(newStr);
    }


    public static String caseSort(String str)
    {
        // Your code here
        int len = str.length();
        char[] ch = str.toCharArray();
        char[] lower = new char[len];
        char[] upper = new char[len];
        char[] ans = new char[len];
        int[] arr = new int[len];

        //1 for lowercase, 2 for uppercase
        int j = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isLowerCase(ch[i])) {
                arr[i] = 1;
                lower[j++] = ch[i];
            }
            else {
                arr[i] = 2;
                upper[k++] = ch[i];
            }
        }
        Arrays.sort(lower);
        Arrays.sort(upper);
        j = k = 0;
        while (j < lower.length && !Character.isAlphabetic(lower[j])) j++;
        while (k < upper.length && !Character.isAlphabetic(upper[k])) k++;

        //processing the resultant character array
        int i = 0;
        while (i < len) {
            if (arr[i] == 1) {
                // System.out.println(lower[j]);
                ans[i] = lower[j];
                j++;
            }
            else {
                ans[i] = upper[k];
                // System.out.println(upper[k]);
                k++;
            }
            i++;
        }
        // System.out.println();
        // for (char chc : ans) System.out.print(chc);
        return new String(ans);
    }
}
