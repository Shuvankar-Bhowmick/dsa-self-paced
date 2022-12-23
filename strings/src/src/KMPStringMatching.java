import java.util.Scanner;

public class KMPStringMatching {

    public static void main(String[] args) {
        String newStr = new String();
        String search = new String();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text: ");
        newStr = sc.nextLine();
        System.out.println("Enter the text to search");
        search = sc.nextLine();

        System.out.println(new KMPStringMatching().KMPSearch(search, newStr));
    }
    void computeLPSArray(String pat, int M, int lps[])
    {
        // Your code here
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }

            }
        }

    }

    //Function to check if the pattern exists in the string or not.
    boolean KMPSearch(String pat, String txt)
    {
        // Your code here
        int M = txt.length();
        int N = pat.length();
        int[] lps = new int[N];
        int i , j;
        i = j = 0;

        computeLPSArray(pat, N, lps);

        while (i < M) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == N)
                return true;

            while (i < M && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }

        return false;

    }
}
