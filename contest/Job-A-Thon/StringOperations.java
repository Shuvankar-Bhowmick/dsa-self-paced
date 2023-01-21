import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.next();

        System.out.println(new StringOperations().solve(str.length(), str));
    }

    public int solve(int N, String s){
        // Code Here
        int count = 0;
        char[] statusArr = vowelOrConsonant(s);
        count = Math.min(flipCharactersStartingWith(statusArr, 'c'), flipCharactersStartingWith(statusArr, 'v'));
        return count;
    }
    static int flipCharactersStartingWith(char[] arr, char ch) {
        int flipCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ch) flipCount++;

            ch = flip(ch);
        }
        return flipCount;
    }
    static char flip (char ch) {
        return ch == 'c' ? 'v' : 'c';
    }
    static char[] vowelOrConsonant(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {
            char ch = str[i];

            switch (ch) {
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    ans[i] = 'v';
                    break;
                default:
                    ans[i] = 'c';
                    break;
            }
        }

        return ans;
    }
}
