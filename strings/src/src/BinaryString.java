public class BinaryString {
    public static void main(String[] args) {
        String str = "11011000110001";
        System.out.println(binarySubstring(str.length(), str));
    }
    public static int binarySubstring(int a, String str)
    {
        // Your code here
        int count = 0;
        int ans = 0;

        for (int i = 0; i < a; i++) {
            if (str.charAt(i) == '1') {
                count++;
                if (count > 1)
                    ans = ans + (count-1);
            }
        }

        return ans;
    }
}
