import java.util.*;

public class SortArrayAccordingToFrequency {
    public static void main(String[] args) {
        //code
        //ascending: n1 - n2
        //descending: n2 - n1
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt()) ;
            }

            //processing
            sortArray(arr);
            printArray(arr);
        }

    }

    static void sortArray(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (Integer i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        Collections.sort(arr, (n1, n2) -> {
            int f1 = mp.get(n1);
            int f2 = mp.get(n2);

            if (f1 != f2) return f2 - f1;
            return n1 - n2;
        });
    }

    static void printArray(ArrayList<Integer> arr) {

        for (Integer i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
