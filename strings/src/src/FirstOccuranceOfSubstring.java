public class FirstOccuranceOfSubstring {
    public static void main(String[] args) {
        String s = "GeeksForGeeks";
        String x = "eeks";
        System.out.println(new FirstOccuranceOfSubstring().strstr(s, x));
    }
    int strstr(String s, String x)
    {
        // Your code here
        int N = s.length();
        int M = x.length();

        //naive pattern searching algorithm
        for (int i = 0; i <= N - M; i++) {
            int j = 0;
            for (; j < M; j++) {
                if (s.charAt(i + j) != x.charAt(j))
                    break;
            }
            if (j == M)
                return i;
        }
        return -1;
    }
}
