public class maxOccuringCharacter {
    public static void main(String[] args) {
        char ch = getMaxOccuringChar("testsample");
        char ch2 = getMaxOccuringChar("output");
        System.out.println(ch);
        System.out.println(ch2);
    }
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        int[] count = new int[256];
        for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i);
            count[index]++;
        }

        int res = Integer.MIN_VALUE;
        int resIndex = 0;
        char resChar = '#';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > res) {
                res = count[i];
                resIndex = i;
            }
        }
        resChar = res == Integer.MIN_VALUE ? resChar : (char) resIndex;
        return resChar;
    }
}
