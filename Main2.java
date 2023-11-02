import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        
        ArrayList<Integer> churros = new ArrayList<>(); 
        for (int i = 0; i < N; i++) {
            churros.add(input.nextInt()); 
        }
        Collections.sort(churros); 

        if (K == 1) {
            System.out.println(churros.get(churros.size() - 1)); 
            System.exit(0); 
        }
        int start = 1;
        int end = churros.get(churros.size() - 1);
        while (start <= end) {
            boolean tof = false;
            int mid = (start + end) / 2;
            int res = 0;
            for (int i = 0; i < N; i++) {
                res += churros.get(i) / mid;
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