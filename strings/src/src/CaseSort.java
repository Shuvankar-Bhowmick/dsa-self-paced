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
        Arrays.fill(lower, '}');
        Arrays.fill(upper, '}');
        //1 for lowercase, 2 for uppercase
        int j = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isLowerCase(ch[i])) {
                lower[j++] = ch[i];
            }
            else {
                upper[k++] = ch[i];
            }
        }
        Arrays.sort(lower);
        Arrays.sort(upper);
        j = k = 0;

        //processing the resultant character array
        int i = 0;
        while (i < len) {
            if (Character.isLowerCase(ch[i])) {
                ans[i] = lower[j];
                j++;
            }
            else {
                ans[i] = upper[k];
                k++;
            }
            i++;
        }
        return new String(ans);
    }
}
