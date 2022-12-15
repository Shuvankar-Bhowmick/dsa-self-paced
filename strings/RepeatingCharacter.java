public class RepeatingCharacter {
    static int repeatedCharacter (String s) {
        boolean[] visited = new boolean[256];
        int res = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char index = s.charAt(i);
            if (visited[index] == false)
                visited[index] = true;
            else
                res = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = new String("geeksforgeeks");
        String newStr = new String("abcd");
        System.out.println(repeatedCharacter(str));
        System.out.println(repeatedCharacter(newStr));
    }
}
