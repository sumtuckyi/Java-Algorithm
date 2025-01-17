import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int K = input.nextInt();  
        int N = input.nextInt(); 
        ArrayList<Integer> lines = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            lines.add(input.nextInt()); 
        }
        Collections.sort(lines);

        if (K == 1) {
            System.out.println(lines.get(lines.size() - 1));
            System.exit(0);
        }
        int start = 1;
        int end = lines.get(lines.size() - 1);
        while (start <= end) {
            boolean tof = false;
            int mid = (start + end) / 2;
            int res = 0;
            for (int i = 0; i < N; i++) {
                res += lines.get(i) / mid;
                if (res >= K) {
                    start = mid + 1;
                    tof = true;
                    break;
                }
            }
            if (!tof) {
                end = mid - 1;
            }
        }
        System.out.println(end);
        input.close();
    }
}
