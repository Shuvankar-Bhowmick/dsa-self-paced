public class reverseWords {
    public static void main(String[] args) {
        String str = reverseWords("I.like.coding!");
        System.out.println(str);
    }
    static String reverseWords(String S)
    {
        // code here
        char[] str = S.toCharArray();
        int start = 0;
        int end = 0;
        for (; end < str.length; end++) {
            if (str[end] == '.') {
                reverseString(str, start, end - 1);
                start = end + 1;
            }
        }
        reverseString(str, start, end - 1);
        reverseString(str, 0, end - 1);

        return new String(str);
    }
    static void reverseString(char[] str, int low, int high) {
        while (low < high) {
            char ch = str[high];
            str[high] = str[low];
            str[low] = ch;

            low++;
            high--;
        }
    }
}
